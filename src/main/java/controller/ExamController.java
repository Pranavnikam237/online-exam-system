package com.pranav.exam.onlineexamsystem.controller;

import com.pranav.exam.onlineexamsystem.dto.AnswerRequest;
import com.pranav.exam.onlineexamsystem.dto.ExamRequest;
import com.pranav.exam.onlineexamsystem.entity.Question;
import com.pranav.exam.onlineexamsystem.entity.Result;
import com.pranav.exam.onlineexamsystem.repository.QuestionRepository;
import com.pranav.exam.onlineexamsystem.repository.ResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/submit")
    public String submitExam(@RequestBody ExamRequest request) {

        int score = 0;

        for (AnswerRequest answer : request.getAnswers()) {

            Question question =
                    questionRepository.findById(answer.getQuestionId())
                            .orElse(null);

            if (question != null &&
                    question.getCorrectAnswer()
                            .equalsIgnoreCase(answer.getSelectedAnswer())) {

                score++;
            }
        }

        Result result = new Result();

        result.setStudentName(request.getStudentName());
        result.setStudentEmail(request.getStudentEmail());
        result.setScore(score);
        result.setExamDate(LocalDateTime.now());

        result.setStartTime(
                LocalDateTime.now().minusMinutes(30)
        );

        result.setEndTime(
                LocalDateTime.now()
        );

        resultRepository.save(result);

        return "Your Score: " + score;
    }

    @GetMapping("/result/{email}")
    public List<Result> getResultByEmail(
            @PathVariable String email) {

        return resultRepository.findByStudentEmail(email);
    }

    @GetMapping("/leaderboard")
    public List<Result> leaderboard() {

        return resultRepository.findLeaderboard();
    }
}
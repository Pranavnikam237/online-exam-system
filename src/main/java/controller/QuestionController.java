package com.pranav.exam.onlineexamsystem.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pranav.exam.onlineexamsystem.entity.Question;
import com.pranav.exam.onlineexamsystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
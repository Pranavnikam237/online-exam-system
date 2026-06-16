
package com.pranav.exam.onlineexamsystem.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pranav.exam.onlineexamsystem.entity.Students;
import com.pranav.exam.onlineexamsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Students saveStudent(@RequestBody Students student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}
package com.pranav.exam.onlineexamsystem.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pranav.exam.onlineexamsystem.entity.Result;
import com.pranav.exam.onlineexamsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping
    public List<Result> getResults() {

        return resultRepository.findAll();
    }
}
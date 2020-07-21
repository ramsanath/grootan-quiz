package com.grootan.quiz.controller;

import com.grootan.quiz.model.dto.QuestionDto;
import com.grootan.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<QuestionDto> getRandomQuestion() {
        return questionService.getRandomQuestions();
    }
}

package com.grootan.quiz.controller;

import com.grootan.quiz.model.dto.QuestionDto;
import com.grootan.quiz.model.dto.VerifyDto;
import com.grootan.quiz.model.dto.VerifyResponseDto;
import com.grootan.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    public List<QuestionDto> getRandomQuestion() {
        return questionService.getRandomQuestions();
    }

    @PostMapping("/questions/verify")
    public List<VerifyResponseDto> verifyQuestions(@RequestBody List<VerifyDto> answers) {
        return questionService.verifyQuestions(answers);
    }
}

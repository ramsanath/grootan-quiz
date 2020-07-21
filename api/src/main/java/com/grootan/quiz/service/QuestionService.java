package com.grootan.quiz.service;

import com.grootan.quiz.dao.MockDatabase;
import com.grootan.quiz.dao.QuestionDao;
import com.grootan.quiz.model.Question;
import com.grootan.quiz.model.dto.QuestionDto;
import com.grootan.quiz.model.dto.VerifyDto;
import com.grootan.quiz.model.dto.VerifyResponseDto;
import com.grootan.quiz.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<QuestionDto> getRandomQuestions() {
        List<Question> questions = questionDao.getAllQuestion();
        return Util.pickRandomElements(questions, 5)
                .stream()
                .map(QuestionDto::fromQuestion)
                .collect(Collectors.toList());
    }

    public List<VerifyResponseDto> verifyQuestions(List<VerifyDto> answers) {
        List<String> ids = answers
                .stream()
                .map(a -> a.getQuestionId())
                .collect(Collectors.toList());
        List<Question> questions = questionDao.getQuestionsByIds(ids);
        System.out.println(questions.size());

        List<VerifyResponseDto> results = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            VerifyDto answer = answers.get(i);
            System.out.print(question.getAnswer());
            System.out.print(" - ");
            System.out.println(answer.getGivenAnswer());
            VerifyResponseDto result = new VerifyResponseDto(
                    question.getId(),
                    question.getAnswer().equals(answer.getGivenAnswer()),
                    question.getAnswer()
            );
            results.add(result);
        }
        return results;
    }
}

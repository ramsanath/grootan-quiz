package com.grootan.quiz.service;

import com.grootan.quiz.dao.MockDatabase;
import com.grootan.quiz.dao.QuestionDao;
import com.grootan.quiz.model.Question;
import com.grootan.quiz.model.dto.QuestionDto;
import com.grootan.quiz.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

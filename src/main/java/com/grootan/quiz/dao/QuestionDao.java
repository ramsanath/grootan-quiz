package com.grootan.quiz.dao;

import com.grootan.quiz.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDao {
    public List<Question> getAllQuestion() {
        return MockDatabase.questions;
    }
}

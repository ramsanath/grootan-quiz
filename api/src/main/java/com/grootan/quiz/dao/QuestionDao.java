package com.grootan.quiz.dao;

import com.grootan.quiz.model.Question;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionDao {
    public List<Question> getAllQuestion() {
        return MockDatabase.questions;
    }

    public List<Question> getQuestionsByIds(List<String> ids) {

        return MockDatabase.questions
                .stream()
                .filter(q -> ids.contains(q.getId()))
                .sorted(Comparator.comparing(e -> ids.indexOf(e.getId())))
                .collect(Collectors.toList());
    }
}

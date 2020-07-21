package com.grootan.quiz.dao;

import com.grootan.quiz.model.Question;
import com.grootan.quiz.model.User;
import com.grootan.quiz.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase {
    public static final List<User> users = new ArrayList<>();
    public static final List<Question> questions = new ArrayList<>();

    static  {
        for (int i = 0; i < 20; i++) {
            int num1 = Util.getRandomNumber(0, 100);
            int num2 = Util.getRandomNumber(0, 100);
            Question question = new Question();
            question.setId(Util.uuid());
            for (int j = 0; j < 4; j++) {
                question.getOptions().add(String.valueOf(Util.getRandomNumber(0, 1000)));
            }
            int operation = Util.getRandomNumber(1, 3);
            int answer;
            String operationName;
            if (operation == 1) {
                operationName = "sum of";
                answer = num1 + num2;
            } else if (operation == 2) {
                operationName = "product of";
                answer = num1 * num2;
            } else {
                operationName = "difference between";
                answer = num1 - num2;
            }
            String answerValue = String.valueOf(answer);
            question.setQuestion(String.format("What is the %s %d and %d?", operationName, num1, num2));
            question.getOptions().set(Util.getRandomNumber(0, 3), answerValue);
            question.setAnswer(answerValue);
            questions.add(question);
        }
    }
}

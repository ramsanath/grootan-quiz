package com.grootan.quiz.model.dto;

import com.grootan.quiz.model.Question;

import java.util.List;

public class QuestionDto {
    private String question;
    private List<String> options;

    public QuestionDto(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public static QuestionDto fromQuestion(Question question) {
        return new QuestionDto(
                question.getQuestion(),
                question.getOptions()
        );

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}

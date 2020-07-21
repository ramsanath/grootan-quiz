package com.grootan.quiz.model.dto;

import com.grootan.quiz.model.Question;

import java.util.List;

public class QuestionDto {
    private String id;
    private String question;
    private List<String> options;

    public QuestionDto(String id, String question, List<String> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public static QuestionDto fromQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getQuestion(),
                question.getOptions()
        );

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

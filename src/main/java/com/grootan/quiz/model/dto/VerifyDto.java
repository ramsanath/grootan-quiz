package com.grootan.quiz.model.dto;

public class VerifyDto {
    private String questionId;
    private String givenAnswer;

    public VerifyDto(String questionId, String givenAnswer) {
        this.questionId = questionId;
        this.givenAnswer = givenAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }
}


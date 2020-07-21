package com.grootan.quiz.model.dto;

public class VerifyResponseDto {
    String questionId;
    boolean isCorrect;
    String correctAnswer;

    public VerifyResponseDto() {
    }

    public VerifyResponseDto(String questionId, boolean isCorrect, String correctAnswer) {
        this.questionId = questionId;
        this.isCorrect = isCorrect;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

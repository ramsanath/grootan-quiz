package com.grootan.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String id;
    private String question;
    private List<String> options;
    private String answer;

    public Question() {
        options = new ArrayList<>();
    }

    public Question(String id, String question, List<String> options, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

package com.grootan.quiz.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

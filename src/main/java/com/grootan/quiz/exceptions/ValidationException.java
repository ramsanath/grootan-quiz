package com.grootan.quiz.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

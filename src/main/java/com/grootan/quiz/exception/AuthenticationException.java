package com.grootan.quiz.exception;

public class AuthenticationException extends org.springframework.security.core.AuthenticationException {
    public AuthenticationException(String message) {
        super(message);
    }
}

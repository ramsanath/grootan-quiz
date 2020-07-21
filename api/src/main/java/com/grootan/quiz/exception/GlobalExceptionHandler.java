package com.grootan.quiz.exception;

import com.grootan.quiz.model.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(401).body(response);
    }
}
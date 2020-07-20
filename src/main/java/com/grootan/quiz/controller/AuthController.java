package com.grootan.quiz.controller;

import com.grootan.quiz.exception.AuthenticationException;
import com.grootan.quiz.model.dto.LoginDto;
import com.grootan.quiz.model.dto.LoginResponseDto;
import com.grootan.quiz.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginDto loginDto) throws AuthenticationException {
        String token = authService.authenticateAndGenerateJwt(loginDto.getUsername(), loginDto.getPassword());
        return new LoginResponseDto(token);
    }
}

package com.grootan.quiz.controller;

import com.grootan.quiz.exception.ValidationException;
import com.grootan.quiz.model.User;
import com.grootan.quiz.model.dto.UserDto;
import com.grootan.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDetail) throws ValidationException {
        return userService.register(userDetail);
    }
}

package com.grootan.quiz.controllers;

import com.grootan.quiz.exceptions.ValidationException;
import com.grootan.quiz.models.User;
import com.grootan.quiz.service.UserService;
import com.grootan.quiz.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @PostMapping("/register")
    public User register(@Valid @RequestBody User params) throws ValidationException {
        userValidator.assertCreateUserParams(params);
        return userService.register(params);
    }
}

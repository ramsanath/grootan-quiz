package com.grootan.quiz.validator;

import com.grootan.quiz.dao.UserDao;
import com.grootan.quiz.model.User;
import com.grootan.quiz.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    @Autowired
    UserDao userDao;

    public String validateCreateUserParams(UserDto params) {
        User existing = userDao.findUserByEmail(params.getEmail());
        if (existing != null) {
            return "Email already in use";
        }
        return null;
    }
}

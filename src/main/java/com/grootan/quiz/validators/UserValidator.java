package com.grootan.quiz.validators;

import com.grootan.quiz.dao.UserDao;
import com.grootan.quiz.exceptions.ValidationException;
import com.grootan.quiz.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    @Autowired
    UserDao userDao;

    public void assertCreateUserParams(User params) throws ValidationException {
        User existing = userDao.findUserByEmail(params.getEmail());
        if (existing != null) {
            throw new ValidationException("Email already in use");
        }
    }
}

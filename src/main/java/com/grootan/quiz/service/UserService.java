package com.grootan.quiz.service;

import com.grootan.quiz.dao.UserDao;
import com.grootan.quiz.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User register(User params) {
        return userDao.createUser(params);
    }
}

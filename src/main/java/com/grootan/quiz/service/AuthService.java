package com.grootan.quiz.service;

import com.grootan.quiz.dao.UserDao;
import com.grootan.quiz.exception.AuthenticationException;
import com.grootan.quiz.model.User;
import com.grootan.quiz.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired
    UserDao userDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String authenticateAndGenerateJwt(String email, String password) throws AuthenticationException {
        User user = userDao.findUserByEmail(email);
        if (user == null) {
            throw new AuthenticationException("User not found");
        }
        boolean isPasswordMatch = passwordEncoder.matches(password, user.getPassword());
        if (!isPasswordMatch) {
            throw new AuthenticationException("Wrong credentials");
        }
        return jwtTokenUtil.createJwt(user.getId());
    }
}

package com.grootan.quiz.service;

import com.grootan.quiz.dao.UserDao;
import com.grootan.quiz.email.EmailClient;
import com.grootan.quiz.email.EmailInterpolator;
import com.grootan.quiz.exception.ValidationException;
import com.grootan.quiz.model.User;
import com.grootan.quiz.model.dto.UserDto;
import com.grootan.quiz.util.Util;
import com.grootan.quiz.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final String VERIFY_ACCOUNT_EMAIL_TEMPLATE_PATH = "templates/verify_account_template.html";

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Autowired
    UserValidator userValidator;

    @Autowired
    EmailClient emailClient;

    @Autowired
    EmailInterpolator emailInterpolator;

    public UserDto register(UserDto userDetail) throws ValidationException {
        String validationError = userValidator.validateCreateUserParams(userDetail);
        if (validationError != null) {
            throw new ValidationException(validationError);
        }
        User user = userDetail.toUser();
        user.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        user.setAccountVerified(false);
        user.setAccountVerificationCode(Util.uuid());
        user = userDao.createUser(user);
        sendAccountVerificationEmail(user);
        return UserDto.fromUser(user);
    }

    public void sendAccountVerificationEmail(User user) {
        Map<String, String> placeholderValues = new HashMap<>();
        placeholderValues.put("#firstName", user.getFirstName());
        placeholderValues.put("#verificationLink", getAccountVerificationLink(user));
        try {
            String emailContent = emailInterpolator.interpolateTemplate(
                    VERIFY_ACCOUNT_EMAIL_TEMPLATE_PATH,
                    placeholderValues);
            emailClient.sendEmail(user.getEmail(), "Account Verification", emailContent);
        } catch (IOException e) {
            System.out.println("Unable to send verification email to User{" + user.getId() + "}");
            e.printStackTrace();
        }
    }

    private String getAccountVerificationLink(User user) {
        String url = "http://localhost:8080/verify?";
        url += ("u=" + user.getId() + "&");
        url += ("c=" + user.getAccountVerificationCode());
        return url;
    }
}

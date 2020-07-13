package com.grootan.quiz.dao;

import com.grootan.quiz.models.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDao {
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        MockDatabase.users.add(user);
        return user;
    }

    public User findUserByEmail(String email) {
        for (User u : MockDatabase.users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
}

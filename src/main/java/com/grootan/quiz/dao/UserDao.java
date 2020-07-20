package com.grootan.quiz.dao;

import com.grootan.quiz.model.User;
import com.grootan.quiz.util.Util;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    public User createUser(User user) {
        user.setId(Util.uuid());
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

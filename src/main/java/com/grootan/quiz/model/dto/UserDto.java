package com.grootan.quiz.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grootan.quiz.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotNull()
    private String firstName;

    private String lastName;

    @NotNull()
    @Email()
    private String email;

    @NotNull()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User toUser() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

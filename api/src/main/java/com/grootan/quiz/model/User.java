package com.grootan.quiz.model;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountVerificationCode;
    private boolean isAccountVerified;

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

    public String getAccountVerificationCode() {
        return accountVerificationCode;
    }

    public void setAccountVerificationCode(String accountVerificationCode) {
        this.accountVerificationCode = accountVerificationCode;
    }

    public boolean isAccountVerified() {
        return isAccountVerified;
    }

    public void setAccountVerified(boolean accountVerified) {
        this.isAccountVerified = accountVerified;
    }
}

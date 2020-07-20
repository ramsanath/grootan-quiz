package com.grootan.quiz.email;

import java.io.IOException;

public interface EmailClient {
    void sendEmail(String to, String subject, String body) throws IOException;
}

package com.grootan.quiz.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class SendGridEmailClient implements EmailClient {
    private static final String sendGridApiKey = "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";

    @Override
    public void sendEmail(String to, String subject, String body) throws IOException {
        Email fromEmail = new Email("account@quiz.com");
        Email toEmail = new Email(to);
        Content content = new Content("text/html", body);
        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
    }
}

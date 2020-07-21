package com.grootan.quiz.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmailInterpolatorTest {
    EmailInterpolator emailInterpolator;

    @Before()
    public void init() {
        emailInterpolator = new EmailInterpolator();
    }

    @Test()
    public void interpolator_should_read_and_interpolate_content() throws IOException {
        String verifyEmailTemplatePath = "templates/verify_account_template.html";
        String firstName = "test-name";
        String verificationLink = "test-link";
        Map<String, String> content = new HashMap<String, String>() {{
            put("#firstName", firstName);
            put("#verificationLink", verificationLink);
        }};

        String interpolatedContent = emailInterpolator.interpolateTemplate(
                verifyEmailTemplatePath,
                content);

        Assert.assertNotNull(interpolatedContent);
        Assert.assertTrue(interpolatedContent.contains(firstName));
        Assert.assertTrue(interpolatedContent.contains(verificationLink));
    }
}

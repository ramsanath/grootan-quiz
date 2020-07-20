package com.grootan.quiz.email;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EmailInterpolator {
    public String interpolateTemplate(String templatePath, Map<String, String> values) throws IOException {
        String template = readResource(templatePath);
        for (String placeholder : values.keySet()) {
            template = template.replaceAll(placeholder, values.get(placeholder));
        }
        return template;
    }

    private String readResource(String resourcePath) throws IOException {
        Resource resource = new ClassPathResource(resourcePath);
        InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);
        return data;
    }
}

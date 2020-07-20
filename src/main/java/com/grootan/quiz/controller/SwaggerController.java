package com.grootan.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
    @RequestMapping("/")
    public String swaggerDocs() {
        return "redirect:/swagger-ui.html";
    }
}

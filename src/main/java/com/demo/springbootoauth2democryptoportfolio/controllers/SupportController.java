package com.demo.springbootoauth2democryptoportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support")
public class SupportController {

    @GetMapping("/admin")
    public String getSupportPage() {
        return "support-admin";
    }

}

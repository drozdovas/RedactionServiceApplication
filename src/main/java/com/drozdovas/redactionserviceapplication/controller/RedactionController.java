package com.drozdovas.redactionserviceapplication.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redact")
public class RedactionController {

    @GetMapping
    public String identifyService() {
        return "Redaction Service";
    }
}
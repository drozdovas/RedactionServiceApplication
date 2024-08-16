package com.drozdovas.redactionserviceapplication.controller;

import com.drozdovas.redactionserviceapplication.service.RedactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/redact")
public class RedactionController {

    private static final Logger logger = LoggerFactory.getLogger(RedactionController.class);

    private final RedactionService redactionService;

    public RedactionController(RedactionService redactionService) {
        this.redactionService = redactionService;
    }

    @GetMapping
    public String identifyService() {
        return "Redaction Service";
    }

    @PostMapping
    public String redactText(@RequestBody String text) {
        logger.info("Received text at {}: {}", LocalDateTime.now(), text);
        return redactionService.redact(text);
    }
}
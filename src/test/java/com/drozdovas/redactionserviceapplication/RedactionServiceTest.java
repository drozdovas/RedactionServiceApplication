package com.drozdovas.redactionserviceapplication;

import com.drozdovas.redactionserviceapplication.config.RedactionConfig;
import com.drozdovas.redactionserviceapplication.service.RedactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RedactionServiceTest {

    private RedactionService redactionService;

    @BeforeEach
    void setUp() {
        RedactionConfig redactionConfig = new RedactionConfig();
        redactionConfig.setWords(List.of("Dog", "Cat", "Snake", "Dolphin", "Mammal"));
        redactionService = new RedactionService(redactionConfig);
    }

    @Test
    void testRedact() {
        String input = "A dog, a monkey or a dolphin are all mammals. A snake, however, is not a mammal, it is a reptile. Who can say what a DogSnake is?";
        String expected = "A REDACTED, a monkey or a REDACTED are all mammals. A REDACTED, however, is not a REDACTED, it is a reptile. Who can say what a DogSnake is?";
        String result = redactionService.redact(input);
        assertEquals(expected, result);
    }

    @Test
    void testRedactWithNoRedactionNeeded() {
        String input = "There are no redacted words here.";
        String expected = input;
        String result = redactionService.redact(input);
        assertEquals(expected, result);
    }
}

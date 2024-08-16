package com.drozdovas.redactionserviceapplication;

import com.drozdovas.redactionserviceapplication.controller.RedactionController;
import com.drozdovas.redactionserviceapplication.service.RedactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RedactionController.class)
class RedactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedactionService redactionService;

    @BeforeEach
    void setUp() {
        when(redactionService.redact("A dog, a monkey or a dolphin are all mammals.")).thenReturn("A REDACTED, a monkey or a REDACTED are all mammals.");
    }

    @Test
    void testIdentifyService() throws Exception {
        mockMvc.perform(get("/redact"))
                .andExpect(status().isOk())
                .andExpect(content().string("Redaction Service"));
    }

    @Test
    void testRedactText() throws Exception {
        String input = "A dog, a monkey or a dolphin are all mammals.";
        String expected = "A REDACTED, a monkey or a REDACTED are all mammals.";

        mockMvc.perform(post("/redact")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void testNoHandlerFoundException() throws Exception {
        mockMvc.perform(get("/redaction"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Path not found: /redaction"));
    }
}

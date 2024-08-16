package com.drozdovas.redactionserviceapplication.service;

import com.drozdovas.redactionserviceapplication.config.RedactionConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class RedactionService {

    private final List<Pattern> redactionPatterns;

    public RedactionService(RedactionConfig config) {
        this.redactionPatterns = config.getWords().stream()
                .map(word -> Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE))
                .collect(Collectors.toList());
    }

    public String redact(String text) {
        for (Pattern pattern : redactionPatterns) {
            text = pattern.matcher(text).replaceAll("REDACTED");
        }
        return text;
    }
}

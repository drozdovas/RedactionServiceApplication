# Redaction Service

## Overview

Redaction Service is a simple Spring Boot application that provides a RESTful web service for text redaction. The service allows users to submit text and returns it with specific words replaced with "REDACTED". The list of words to be redacted is configurable. Additionally, the service logs each POST request, including the original text before redaction. Service PORT number can be configured in the application.yml file.

## Features

- **Redaction of Specified Words**: Replace sensitive words in the input text with "REDACTED".
- **Configurable Redaction List**: Customize the list of words to be redacted via configuration.
- **Customizable Port**: The service can be configured to run on any port specified at runtime.
- **Request Logging**: Logs every POST request with the original text before redaction.
- **Custom 404 Handling**: Logs attempts to access undefined paths and returns a custom 404 message.

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.2**
    - **Spring Web**: To create RESTful web services.
    - **Spring Boot Starter Logging**: For logging using Logback.
    - **Spring Boot Starter Test**: For unit and integration testing. 
- **Maven**

## Endpoints

### 1. GET `/redact`
- **Description**: Identifies the service by returning a simple message.
- **Response**: `"Redaction Service"`

### 2. POST `/redact`
- **Description**: Accepts arbitrary text and returns it with specified words redacted.
- **Request Body**: Plain text.
- **Response**: The redacted text.

#### Example Request
```plaintext
POST /redact
Content-Type: text/plain

A dog, a monkey or a dolphin are all mammals.
```

## Time scales
Redaction Service took around 2 hours to complete.
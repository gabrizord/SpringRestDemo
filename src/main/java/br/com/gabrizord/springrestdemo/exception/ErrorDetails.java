package br.com.gabrizord.springrestdemo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDetails {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public ErrorDetails(int statusCode, String message, LocalDateTime timestamp, List<String> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public ErrorDetails(int statusCode, String message, LocalDateTime timestamp) {
        this(statusCode, message, timestamp, null);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

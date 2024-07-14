package br.com.gabrizord.springrestdemo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
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

}

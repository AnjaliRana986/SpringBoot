package com.anjali.rest.websevices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    //define standard structure of the error
    //timestamp
    //error message
    //details of the error
    private LocalDateTime timsstamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timsstamp, String message, String details) {
        this.timsstamp = timsstamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimsstamp() {
        return timsstamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

package com.Liveasy.exception;

import java.time.LocalDate;

public class ErrorResponse {
    private LocalDate timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    // Default constructor
    public ErrorResponse() {
    }

    // Parameterized constructor
    public ErrorResponse(LocalDate timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getter and Setter for timestamp
    public LocalDate getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    // Getter and Setter for status
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    // Getter and Setter for error
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for path
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}

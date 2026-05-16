package fr.captain.exception;

import java.sql.Timestamp;

public class StudentErrorResponse {

    private int statusCode;
    private String message;
    private Timestamp timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int statusCode, String message, Timestamp timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

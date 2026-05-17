package fr.captain.rest;

import fr.captain.exception.StudentErrorResponse;
import fr.captain.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class StudentRESTExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(Timestamp.from(Instant.now()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(Timestamp.from(Instant.now()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

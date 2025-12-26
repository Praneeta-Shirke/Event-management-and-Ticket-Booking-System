package com.smart.event.event_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST
        );
    }

    //  THIS IS THE VALIDATION ERROR HANDLER
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return new ResponseEntity<>(
                new ErrorResponse(message, HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST
        );
    }

    // Fallback handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse("Internal server error", 500),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

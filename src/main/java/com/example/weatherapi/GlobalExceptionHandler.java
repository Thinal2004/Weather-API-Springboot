package com.example.weatherapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // This specifically intercepts 404 errors from the RestClient
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ErrorResponse> handleCityNotFound(HttpClientErrorException.NotFound ex) {
        ErrorResponse error = new ErrorResponse(404, "City not found. Please check the spelling and try again.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Intercepts other client errors (like 401 if your API key expires)
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleOtherClientErrors(HttpClientErrorException ex) {
        ErrorResponse error = new ErrorResponse(ex.getStatusCode().value(), "Unable to fetch weather data at this time.");
        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}
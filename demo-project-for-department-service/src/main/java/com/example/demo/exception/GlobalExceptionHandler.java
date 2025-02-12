package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)

    public ResponseEntity<com.example.SpringBootProject.exception.ErrorDetails> handleEmailAlreadyExists(DepartmentNotFoundException departmentNotFoundException,
                                                                                                         WebRequest webRequest) {
        com.example.SpringBootProject.exception.ErrorDetails errorDeatils = new com.example.SpringBootProject.exception.ErrorDetails(
                LocalDateTime.now(),
                departmentNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "400.0.2_USER_NOT_FOUND"
        );

        return new ResponseEntity<>(errorDeatils, HttpStatus.BAD_REQUEST);
    }

}

package com.example.SpringBootProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private  LocalDateTime stamp;
    private String errorMessage;
    private String path;
    private String errorCode;

}

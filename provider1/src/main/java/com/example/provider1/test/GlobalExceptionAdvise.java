package com.example.provider1.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvise {

    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        return null;
    }
}


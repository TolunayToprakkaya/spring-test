package com.example.demo.seedwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(org.springframework.data.rest.webmvc.ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleResourceNotFoundException(Exception e){
        LOGGER.error(e.getMessage());
        return new ResponseEntity<String>("Kayit bulunamadi", HttpStatus.OK);
    }
}

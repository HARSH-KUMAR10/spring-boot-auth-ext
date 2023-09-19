package com.harshkumar093.jpa.annotation;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ForbiddenResourceException.class)
    public ResponseEntity<ResponseMessage> handleMyCustomException(ForbiddenResourceException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseMessage("403",ex.getMessage()));
    }
}

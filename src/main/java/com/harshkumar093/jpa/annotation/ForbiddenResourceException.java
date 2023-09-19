package com.harshkumar093.jpa.annotation;

import lombok.Data;

@Data
public class ForbiddenResourceException extends RuntimeException{
    private long statusCode;
    private String message;
    public ForbiddenResourceException(long statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}

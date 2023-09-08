package com.harshkumar093.jpa.payload.response;

import lombok.Data;

@Data
public class ResponseMessage<E> {
    private String statusCode;
    private String message;
    private E data;
    public ResponseMessage(String statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
    public ResponseMessage(String statusCode, String message, E data){
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}

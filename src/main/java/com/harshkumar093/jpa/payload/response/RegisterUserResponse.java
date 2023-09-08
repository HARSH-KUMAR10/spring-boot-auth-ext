package com.harshkumar093.jpa.payload.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private long userId;
    public RegisterUserResponse(long userId){
        this.userId = userId;
    }
}

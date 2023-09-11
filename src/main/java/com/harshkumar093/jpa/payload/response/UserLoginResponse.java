package com.harshkumar093.jpa.payload.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    String jwt;
    public UserLoginResponse(String jwt){
        this.jwt = jwt;
    }
}

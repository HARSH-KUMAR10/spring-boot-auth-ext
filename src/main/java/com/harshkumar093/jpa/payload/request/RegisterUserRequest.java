package com.harshkumar093.jpa.payload.request;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userId;
    private String secret;
}

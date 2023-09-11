package com.harshkumar093.jpa.payload.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RegisterUserRequest {
    private String userId;
    private String secret;
    private ArrayList<String> roles;
}

package com.harshkumar093.jpa;

import com.harshkumar093.jpa.payload.request.RegisterUserRequest;
import com.harshkumar093.jpa.payload.response.RegisterUserResponse;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import com.harshkumar093.jpa.service.user.CoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    CoreUserService coreUserService;

    @GetMapping("/")
    public ResponseMessage<String> welcome(){
        return new ResponseMessage<>("200","Welcome to auth-ext");
    }
    @PostMapping("/register")
    public ResponseMessage<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        return coreUserService.registerUser(registerUserRequest);
    }
}

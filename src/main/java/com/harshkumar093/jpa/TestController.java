package com.harshkumar093.jpa;

import com.harshkumar093.jpa.annotation.RequireJwt;
import com.harshkumar093.jpa.annotation.RequireRole;
import com.harshkumar093.jpa.payload.request.AddModulesRequest;
import com.harshkumar093.jpa.payload.request.RegisterUserRequest;
import com.harshkumar093.jpa.payload.request.UserLoginRequest;
import com.harshkumar093.jpa.payload.response.RegisterUserResponse;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import com.harshkumar093.jpa.service.module.CoreModuleService;
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

    @Autowired
    CoreModuleService coreModuleService;

    @GetMapping("/")
    @RequireJwt()
    @RequireRole({"MANAGER"})
    public ResponseMessage<String> welcome(){
        System.out.println("In controller");
        return new ResponseMessage<>("200","Welcome to auth-ext");
    }
    @PostMapping("/sign-up")
    public ResponseMessage<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        return coreUserService.registerUser(registerUserRequest);
    }

    @PostMapping("/sign-in")
    public ResponseMessage loginUser(@RequestBody UserLoginRequest userLoginRequest){
        return this.coreUserService.login(userLoginRequest);
    }

    @PostMapping("/modules")
    public ResponseMessage addModules(@RequestBody AddModulesRequest addModulesRequest){
        return this.coreModuleService.addModules(addModulesRequest);
    }
}

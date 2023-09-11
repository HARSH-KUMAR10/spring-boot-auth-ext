package com.harshkumar093.jpa.service.user;

import com.harshkumar093.jpa.extension.JwtExtension;
import com.harshkumar093.jpa.model.role.CoreRole;
import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.model.user.CoreUser;
import com.harshkumar093.jpa.payload.request.RegisterUserRequest;
import com.harshkumar093.jpa.payload.request.UserLoginRequest;
import com.harshkumar093.jpa.payload.response.RegisterUserResponse;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import com.harshkumar093.jpa.payload.response.UserLoginResponse;
import com.harshkumar093.jpa.repo.CoreRoleRepository;
import com.harshkumar093.jpa.repo.CoreUserRepository;
import com.harshkumar093.jpa.repo.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoreUserService {

    @Autowired
    JwtExtension jwtExtension;

    @Autowired
    CoreUserRepository coreUserRepository;

    @Autowired
    CoreRoleRepository coreRoleRepository;

    @Autowired
    RolesRepository rolesRepository;

    public ResponseMessage<RegisterUserResponse> registerUser(RegisterUserRequest registerUserRequest){
        try{
            CoreUser newUser = coreUserRepository.save(new CoreUser(registerUserRequest.getUserId(),registerUserRequest.getSecret()));
            ArrayList<Roles> roles = new ArrayList<>();
            for(String role: registerUserRequest.getRoles()){
                System.out.println(newUser);
                System.out.println(role);
                roles.add(this.rolesRepository.findByRole(role));
            }
            coreRoleRepository.save(new CoreRole(newUser, roles));
            return new ResponseMessage<RegisterUserResponse>("200","User created successfully", new RegisterUserResponse(newUser.getId()));
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseMessage<>("500","Failed to create user");
        }
    }

    public ResponseMessage login(UserLoginRequest userLoginRequest){
        CoreUser coreUser = this.coreUserRepository.findByUserId(userLoginRequest.userId);
        if(coreUser==null){
            return new ResponseMessage("404","User not found");
        }
        if(coreUser.getSecret().equals(userLoginRequest.secret)){
            return new ResponseMessage<UserLoginResponse>("200","User logged in successfully", new UserLoginResponse(this.jwtExtension.coreUserJwtCreation(coreUser.getId(), coreUser.getUserId())));
        }else{
            return new ResponseMessage("403", "Wrong password entered");
        }
    }

}

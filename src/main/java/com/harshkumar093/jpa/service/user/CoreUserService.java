package com.harshkumar093.jpa.service.user;

import com.harshkumar093.jpa.model.role.CoreRole;
import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.model.user.CoreUser;
import com.harshkumar093.jpa.payload.request.RegisterUserRequest;
import com.harshkumar093.jpa.payload.response.RegisterUserResponse;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import com.harshkumar093.jpa.repo.CoreRoleRepository;
import com.harshkumar093.jpa.repo.CoreUserRepository;
import com.harshkumar093.jpa.repo.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreUserService {
    @Autowired
    CoreUserRepository coreUserRepository;

    @Autowired
    CoreRoleRepository coreRoleRepository;

    @Autowired
    RolesRepository rolesRepository;

    public ResponseMessage<RegisterUserResponse> registerUser(RegisterUserRequest registerUserRequest){
        try{
            CoreUser newUser = coreUserRepository.save(new CoreUser(registerUserRequest.getUserId(),registerUserRequest.getSecret()));
            coreRoleRepository.save(new CoreRole(newUser,rolesRepository.findById(1L).orElse(new Roles("USER"))));
            return new ResponseMessage<RegisterUserResponse>("200","User created successfully", new RegisterUserResponse(newUser.getId()));
        }catch (Exception exception){
            return new ResponseMessage<>("500","Failed to create user");
        }
    }

}

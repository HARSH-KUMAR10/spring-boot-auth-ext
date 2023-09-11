package com.harshkumar093.jpa.extension;

import com.harshkumar093.jpa.config.JwtConfig;
import com.harshkumar093.jpa.model.role.CoreRole;
import com.harshkumar093.jpa.repo.CoreRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class JwtExtension {
    @Autowired
    public JwtConfig jwtConfig;

    @Autowired
    CoreRoleRepository coreRoleRepository;

    public String coreUserJwtCreation(long id, String userId){
        CoreRole coreRole = this.coreRoleRepository.findRolesByUserId(id);
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",id);
        claims.put("userId", userId);
        claims.put("roles",coreRole.getRoles());
        return this.jwtConfig.generateToken(claims);
    }
}

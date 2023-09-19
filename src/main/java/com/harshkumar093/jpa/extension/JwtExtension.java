package com.harshkumar093.jpa.extension;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshkumar093.jpa.config.JwtConfig;
import com.harshkumar093.jpa.model.role.CoreRole;
import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.repo.CoreRoleRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
    public List<Roles> getRolesFromJwt(String token){
        Claims claims = jwtConfig.getClaimsFromToken(token);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(claims.get("roles"), new TypeReference<List<Roles>>() {});
    }

    public boolean validateJwt(String token){
        return jwtConfig.validateToken(token);
    }
}

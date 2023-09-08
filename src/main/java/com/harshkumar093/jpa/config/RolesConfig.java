package com.harshkumar093.jpa.config;

import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.repo.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolesConfig {
    @Autowired
    RolesRepository rolesRepository;

    public boolean setRoles(String[] roles){
        try {
            if (roles == null || roles.length == 0) {
                rolesRepository.save(new Roles("USER"));
                rolesRepository.save(new Roles("MODERATOR"));
                rolesRepository.save(new Roles("ADMIN"));
            } else {
                for (String role : roles) {
                    rolesRepository.save(new Roles(role));
                }
            }
            return true;
        }catch(Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}

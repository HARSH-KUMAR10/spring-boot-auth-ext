package com.harshkumar093.jpa.config;

import com.harshkumar093.jpa.model.module.Module;
import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.repo.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {
    @Autowired
    ModuleRepository moduleRepository;

    public boolean setModules(String[] modules){
        try {
            if (modules == null || modules.length == 0) {
                System.out.println("No module configuration provided.");
            } else {
                for (String module : modules) {
                    moduleRepository.save(new Module(module,0)); // 0-Create
                    moduleRepository.save(new Module(module,1)); // 1-Read
                    moduleRepository.save(new Module(module,2)); // 2-Update
                    moduleRepository.save(new Module(module,3)); // 3-Delete
                }
            }
            return true;
        }catch(Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}

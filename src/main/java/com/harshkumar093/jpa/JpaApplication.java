package com.harshkumar093.jpa;

import com.harshkumar093.jpa.config.RolesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	RolesConfig rolesConfig;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		if(rolesConfig.setRoles(new String[]{"EMPLOYEE","HR","MANAGER","HEAD"})){
			System.out.println("New roles added");
		}else{
			System.out.println("Failed to set roles");
		}
	}

}

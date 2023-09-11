package com.harshkumar093.jpa.model.role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Roles {
    @Id
    @GeneratedValue
    private long id;
    private String role;

    public Roles(){}

    public Roles(String role){
        this.role = role;
    }
}

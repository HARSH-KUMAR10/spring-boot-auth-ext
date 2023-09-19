package com.harshkumar093.jpa.model.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Module {
    @Id
    @GeneratedValue
    private long moduleId;
    private String moduleName;
    private int accessPermission;
    public Module(String moduleName, int accessPermission){
        this.moduleName = moduleName;
        this.accessPermission = accessPermission;
    }
    public Module(){}
}

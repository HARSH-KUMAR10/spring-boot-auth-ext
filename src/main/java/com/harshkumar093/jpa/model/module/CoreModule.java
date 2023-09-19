package com.harshkumar093.jpa.model.module;

import com.harshkumar093.jpa.extension.UserExtension;
import com.harshkumar093.jpa.model.role.Roles;
import com.harshkumar093.jpa.model.user.CoreUser;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CoreModule extends UserExtension {
    @ManyToMany
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private List<Module> modules;

    public CoreModule(CoreUser coreUser, List<Module> modules){
        this.modules = modules;
        this.setCoreUser(coreUser);
    }
}

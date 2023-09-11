package com.harshkumar093.jpa.model.role;

import com.harshkumar093.jpa.extension.UserExtension;
import com.harshkumar093.jpa.model.user.CoreUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CoreRole extends UserExtension {
    @ManyToMany
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private List<Roles> roles;

    public CoreRole(CoreUser coreUser, List<Roles> roles){
        this.roles = roles;
        this.setCoreUser(coreUser);
    }
    public CoreRole(){}
}

package com.harshkumar093.jpa.model.role;

import com.harshkumar093.jpa.extension.UserExtension;
import com.harshkumar093.jpa.model.user.CoreUser;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CoreRole extends UserExtension {
    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Roles roles;

    public CoreRole(CoreUser coreUser, Roles roles){
        this.roles = roles;
        this.setCoreUser(coreUser);
    }
}

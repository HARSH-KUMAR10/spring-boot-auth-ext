package com.harshkumar093.jpa.repo;

import com.harshkumar093.jpa.model.role.CoreRole;
import com.harshkumar093.jpa.model.user.CoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreRoleRepository extends JpaRepository<CoreRole, Long> {
    List<CoreRole> findRolesByCoreUser(CoreUser coreUser);

    @Query("Select cr from CoreRole cr WHERE cr.id = (select id from UserExtension ue where ue.coreUser.id=?1)")
    CoreRole findRolesByUserId(long user_id);
}

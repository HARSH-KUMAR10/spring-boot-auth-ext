package com.harshkumar093.jpa.repo;

import com.harshkumar093.jpa.model.role.CoreRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreRoleRepository extends JpaRepository<CoreRole, Long> {
}

package com.harshkumar093.jpa.repo;

import com.harshkumar093.jpa.model.role.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}

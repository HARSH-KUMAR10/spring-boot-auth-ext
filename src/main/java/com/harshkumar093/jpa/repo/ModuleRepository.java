package com.harshkumar093.jpa.repo;

import com.harshkumar093.jpa.model.module.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}

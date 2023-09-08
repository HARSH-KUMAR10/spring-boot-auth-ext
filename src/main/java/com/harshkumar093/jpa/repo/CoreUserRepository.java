package com.harshkumar093.jpa.repo;

import com.harshkumar093.jpa.model.user.CoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreUserRepository extends JpaRepository<CoreUser,Long> {
}

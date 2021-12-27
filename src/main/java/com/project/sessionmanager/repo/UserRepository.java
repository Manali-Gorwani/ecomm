package com.project.sessionmanager.repo;

import com.project.sessionmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    public User findByUsername(String username);
    public List<User> findByRole(String role);
}

package com.servicenow.app.respository;

import com.servicenow.app.entity.User;
import com.servicenow.app.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
}

package com.myservice.app.respository;

import com.myservice.app.entity.User;
import com.myservice.app.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
}

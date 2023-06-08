package com.example.authenticationService.userAuthentication.repository;



import com.example.authenticationService.userAuthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findByUsername(String username);
}

package com.example.userService.userService.repositories;

import com.example.userService.userService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByUsername(String username);
//
//    List<User> findByUserID(Long id);
}
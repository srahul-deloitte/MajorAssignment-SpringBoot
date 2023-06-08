package com.example.userService.userService.services;

import com.example.userService.userService.exceptions.ResourceAlreadyExistsException;
import com.example.userService.userService.models.User;
import com.example.userService.userService.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        if(user.getId() != null) {
            Optional<User> u = userRepository.findById(user.getId());
            if (u.isPresent()) {
                logger.error("createUser {} User already exists!", this.getClass().getName());
                throw new ResourceAlreadyExistsException();
            }
        }
        logger.info("createUser {}", this.getClass().getName());
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()) {
            logger.info("getAllUsers {}", this.getClass().getName());
            return users;
        } else {
            logger.error("getAllUsers {} User not Found!", this.getClass().getName());
        }
        return users;
    }

    public User getUser(Long id)  {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            logger.info("getUser {}", this.getClass().getName());
            return user.get();
        } else {
            logger.error("getUser {} User not Found!", this.getClass().getName());
            throw  new RuntimeException(" User not found");

        }

    }
}

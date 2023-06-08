package com.example.userService.userService.controller;


import com.example.userService.userService.models.User;
import com.example.userService.userService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@Component
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> retrieveAllUsers() {
        logger.info("retrieve all users ");
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> retrieveUserById(@PathVariable long id) {

        logger.info("retrieve user controller...!");
       User user = userService.getUser(id);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/userSignup")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        logger.info("create user ");

        User savedUser = userService.createUser(user);
        return new ResponseEntity<User>(savedUser, new HttpHeaders(), HttpStatus.CREATED);
    }



}

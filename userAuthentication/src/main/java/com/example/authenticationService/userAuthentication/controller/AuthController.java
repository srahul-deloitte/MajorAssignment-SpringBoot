package com.example.authenticationService.userAuthentication.controller;

import com.example.authenticationService.userAuthentication.dto.AuthRequest;
import com.example.authenticationService.userAuthentication.entity.User;
import com.example.authenticationService.userAuthentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/register")

    public User addNewUser(@RequestBody User user) {
//        System.out.println("Inside Controller");
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "token", service.generateToken(authRequest.getUsername())));
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}

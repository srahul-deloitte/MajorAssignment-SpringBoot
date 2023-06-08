package com.example.authenticationService.userAuthentication.service;


import com.example.authenticationService.userAuthentication.entity.User;
//import com.example.authenticationService.userAuthentication.feign.apis.UserAPI;
import com.example.authenticationService.userAuthentication.feign.apis.UserAPI;
import com.example.authenticationService.userAuthentication.repository.UserCredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {

    @Autowired
    private  UserAPI userApi;

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User saveUser(User credential) {
        System.out.println("Inside Service");
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        User user = repository.save(credential);
        userApi.createUser(credential);
        return user;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}

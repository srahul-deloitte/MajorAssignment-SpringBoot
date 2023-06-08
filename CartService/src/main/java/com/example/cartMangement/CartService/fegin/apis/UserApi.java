package com.example.cartMangement.CartService.fegin.apis;

import com.example.cartMangement.CartService.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="userService",url = "http://localhost:8082/api/user")
public interface UserApi {
    @GetMapping("/users/{id}")
    public ResponseEntity<User> retrieveUserById(@PathVariable Long id);

}
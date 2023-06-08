package com.example.authenticationService.userAuthentication.feign.apis;


import com.example.authenticationService.userAuthentication.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="userService",url = "http://localhost:8082/api/user")
public interface UserAPI {
	@PostMapping("/userSignup")
	public ResponseEntity<User> createUser(@RequestBody User user);

}

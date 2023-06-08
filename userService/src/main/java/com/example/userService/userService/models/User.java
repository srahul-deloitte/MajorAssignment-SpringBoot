package com.example.userService.userService.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usertable")
public class User {

    @Id
    private Long id;
    private String emailid;
    private String name;
    private String username;
    @JsonIgnore
    private String password;

}
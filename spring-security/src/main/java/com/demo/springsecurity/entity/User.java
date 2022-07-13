package com.demo.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
}

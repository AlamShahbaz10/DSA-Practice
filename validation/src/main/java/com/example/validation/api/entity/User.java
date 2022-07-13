package com.example.validation.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private int age;
    private String emailId;
    private String mobileNumber;
    private String nationality;

}

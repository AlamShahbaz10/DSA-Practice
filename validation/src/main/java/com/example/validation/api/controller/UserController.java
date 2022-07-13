package com.example.validation.api.controller;

import com.example.validation.api.dto.UserRequest;
import com.example.validation.api.entity.User;
import com.example.validation.api.exception.UserNotFoundException;
import com.example.validation.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest request){
        return new ResponseEntity<>(service.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUserById(id));
    }
}

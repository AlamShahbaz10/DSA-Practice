package com.example.validation.api.service;

import com.example.validation.api.dto.UserRequest;
import com.example.validation.api.entity.User;
import com.example.validation.api.exception.UserNotFoundException;
import com.example.validation.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(UserRequest request){
        return repo.save(User.build(0, request.getName(), request.getAge(), request.getEmailId(), request.getMobileNumber(), request.getNationality()));
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user = repo.findByUserId(id);
        if(user != null){
            return user;
        }
        else{
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

}

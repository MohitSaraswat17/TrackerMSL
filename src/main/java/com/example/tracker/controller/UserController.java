package com.example.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracker.dto.Userdto;
import com.example.tracker.model.User;
import com.example.tracker.response.UserResponsedto;
import com.example.tracker.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody Userdto userdto){
        User user = userService.createUser(userdto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody Userdto userdto) {
        User updatedUser = userService.updateUser(id, userdto);
        
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public UserResponsedto getUserById(@PathVariable Long userId) {
        return userService.getUserDtoById(userId);
    }
}

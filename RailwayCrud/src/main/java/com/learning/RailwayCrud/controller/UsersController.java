package com.learning.RailwayCrud.controller;

import com.learning.RailwayCrud.dto.UsersDTO;
import com.learning.RailwayCrud.entity.Users;
import com.learning.RailwayCrud.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/users")
public class UsersController {
    @Autowired
    private UserServices userService; // Changed service type and variable name

    @GetMapping("/list")
    private ResponseEntity<List<UsersDTO>> getAllUsers() { // Changed method and DTO type
        try {
            return ResponseEntity.ok(userService.getAllUsers()); // Changed service method
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<UsersDTO> saveUser(@RequestBody Users user){ // Changed parameter type
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user)); // Changed service method
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<UsersDTO> getUserById(@PathVariable("id") long id){ // Changed parameter type to int
        try {
            return ResponseEntity.ok(userService.getUserById(id)); // Changed service method
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<UsersDTO> updateUser(@RequestBody Users user){ // Changed parameter type
        try {
            return ResponseEntity.ok(userService.updateUser(user)); // Changed service method
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteUser(@RequestBody Users user){ //changed parameter type
        try {
            userService.deleteUser(user); // Changed service method
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

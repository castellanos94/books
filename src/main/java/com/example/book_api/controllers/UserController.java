package com.example.book_api.controllers;

import com.example.book_api.bo.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public interface UserController {
    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @PostMapping("/users")
    ResponseEntity<User> addUser(@RequestBody @Valid User user);

    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user);

    @DeleteMapping("/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

}

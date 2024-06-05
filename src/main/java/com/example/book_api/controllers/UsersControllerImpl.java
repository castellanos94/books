package com.example.book_api.controllers;

import com.example.book_api.bo.User;
import com.example.book_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersControllerImpl implements UserController{
    @Autowired
    private UserRepository repository;
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = repository.findAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User user) {
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(repository.save(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        return null;
    }
}

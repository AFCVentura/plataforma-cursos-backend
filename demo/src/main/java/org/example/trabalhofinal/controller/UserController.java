package org.example.trabalhofinal.controller;

import org.example.trabalhofinal.repository.*;
import org.example.trabalhofinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository repository;

    @GetMapping("/todos")
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return repository.save(user);
    }
}

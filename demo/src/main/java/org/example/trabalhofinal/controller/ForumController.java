package org.example.trabalhofinal.controller;

import org.example.trabalhofinal.repository.*;
import org.example.trabalhofinal.model.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    public ForumRepository repository;

    @GetMapping("/todos")
    public List<Forum> getAllForum() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable Long id) {
        Optional<Forum> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteForum(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Forum createForum(@RequestBody Forum forum) {
        return repository.save(forum);
    }

    @PutMapping
    public Forum updateForum(@RequestBody Forum forum) {
        return repository.save(forum);
    }
}
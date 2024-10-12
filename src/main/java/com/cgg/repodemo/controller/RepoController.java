package com.cgg.repodemo.controller;

import com.cgg.repodemo.Model.Repo;
import com.cgg.repodemo.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repos")
public class RepoController {

    @Autowired
    private RepoService repoService;

    @GetMapping
    public List<Repo> getAllUsers() {
        return repoService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Repo> getUserById(@PathVariable Long id) {
        return repoService.getUserById(id);
    }

    @PostMapping
    public Repo createUser(@RequestBody Repo Repo) {
        return repoService.createUser(Repo);
    }

    @PutMapping("/{id}")
    public Repo updateUser(@PathVariable Long id, @RequestBody Repo updatedUser) {
        Optional<Repo> existingUser = repoService.getUserById(id);
        if (existingUser.isPresent()) {
            Repo user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setN_data(updatedUser.getN_data());
            user.setP_data(updatedUser.getP_data());
            user.setK_data(updatedUser.getK_data());
            return repoService.updateUser(user);
        }
        return null;  // Or throw an exception if not found
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        repoService.deleteUserById(id);
    }
}
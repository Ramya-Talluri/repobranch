package com.cgg.repodemo.service;

import com.cgg.repodemo.Model.Repo;
import com.cgg.repodemo.Repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepoService {

    @Autowired
    private RepoRepository repoRepository;

    public List<Repo> getAllUsers() {
        return repoRepository.findAll();
    }

    public Optional<Repo> getUserById(Long id) {
        return repoRepository.findById(id);
    }

    public Repo createUser(Repo user) {
        return repoRepository.save(user);
    }

    public Repo updateUser(Repo user) {
        return repoRepository.save(user);
    }

    public void deleteUserById(Long id) {
        repoRepository.deleteById(id);
    }
}
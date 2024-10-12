package com.cgg.repodemo.Repository;

import com.cgg.repodemo.Model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {



}
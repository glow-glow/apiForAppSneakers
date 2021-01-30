package com.example.apiForAppSneakers.repos;

import com.example.apiForAppSneakers.entity.Sneakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SneakersRepos extends JpaRepository<Sneakers, UUID> {
}

package com.example.apiForAppSneakers.repos;

import com.example.apiForAppSneakers.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShopRepos extends JpaRepository<Shop, UUID> {
}

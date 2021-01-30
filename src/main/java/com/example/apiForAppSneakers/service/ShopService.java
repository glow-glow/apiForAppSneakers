package com.example.apiForAppSneakers.service;


import com.example.apiForAppSneakers.entity.Shop;
import com.example.apiForAppSneakers.repos.ShopRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepos shopRepos;

    public void deleteAll(){
        shopRepos.deleteAll();
    }
    public List<Shop> findAll(){
        return shopRepos.findAll();
    }
    public Shop findById(UUID id){
        return shopRepos.findById(id).get();

    }
    public void save(Shop shop){
        shopRepos.save(shop);
    }


}

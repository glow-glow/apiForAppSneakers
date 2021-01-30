package com.example.apiForAppSneakers.service;

import com.example.apiForAppSneakers.entity.Sneakers;
import com.example.apiForAppSneakers.repos.SneakersRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SneakersService {
    private final SneakersRepos sneakersRepos;

    public void deleteAll(){
       sneakersRepos.deleteAll();
    }
    public List<Sneakers> findAll(){
        return sneakersRepos.findAll();
    }

    public void save (Sneakers sneakers){
        sneakersRepos.save(sneakers);
    }




}


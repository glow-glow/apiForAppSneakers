package com.example.apiForAppSneakers.controller;

import com.example.apiForAppSneakers.entity.Sneakers;
import com.example.apiForAppSneakers.service.SneakersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@ComponentScan(basePackages = {"com.example.*"})
@RequestMapping("sneakers")
public class SneakersController {
    private final SneakersService sneakersService;

    @GetMapping("/all")
    public ResponseEntity<List<Sneakers>> findAll() {



        return ResponseEntity.ok(sneakersService.findAll());
    }
    @DeleteMapping("/delete/allSneakers")
    public ResponseEntity deleteAll() {

        try {
            sneakersService.deleteAll();
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity(  " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK); // просто отправляем статус 200 (операция прошла успешно)
    }


}

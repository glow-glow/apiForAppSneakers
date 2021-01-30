package com.example.apiForAppSneakers.controller;

import com.example.apiForAppSneakers.entity.Shop;
import com.example.apiForAppSneakers.service.ShopService;
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
@RequestMapping("shop")

public class ShopController {
    private final ShopService shopService;

    @GetMapping("/all")
    public List<Shop> findAll() {
        return shopService.findAll();
    }
    @DeleteMapping("/delete/allShop")
    public ResponseEntity deleteAll() {

        try {
            shopService.deleteAll();
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity(  " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK); // просто отправляем статус 200 (операция прошла успешно)
    }
}

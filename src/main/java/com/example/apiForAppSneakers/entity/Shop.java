package com.example.apiForAppSneakers.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "name_shop")
    private  String nameShop;
    @Basic
    @Column(name = "img_url")
    private String imgUrl;

    public Shop(){
        id = UUID.randomUUID();

    }
}

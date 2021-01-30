package com.example.apiForAppSneakers.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "sneakers")
public class Sneakers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "name_sneakers")
    private  String nameSneakers;
    @Basic
    @Column(name = "url_sneakers")
    private  String urlSneakers;
    @Basic
    @Column(name = "old_price_sneakers")
    private  String oldPriceSneakers;
    @Basic
    @Column(name = "new_price_sneakers")
    private  String newPriceSneakers;
    @Basic
    @Column(name = "img_url")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name="shop_id", referencedColumnName = "id")
    private Shop shop;

    public Sneakers(){
        id = UUID.randomUUID();

    }
}

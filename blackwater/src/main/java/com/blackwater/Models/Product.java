package com.blackwater.Models;

import com.blackwater.Repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    @Column(scale = 2)
    private float price;
    @Column(scale = 2)
    private float rating;

    @OneToMany(mappedBy = "product",
        cascade = CascadeType.ALL)
    private Set<ProductSale> productSales;


    public Product() {

    }

    public Product(String name, String description, float price, float rating) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

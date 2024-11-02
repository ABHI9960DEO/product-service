package com.scaler.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    //private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}

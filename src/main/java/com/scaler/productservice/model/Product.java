package com.scaler.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    //@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id")
    private Category categoryName;
}

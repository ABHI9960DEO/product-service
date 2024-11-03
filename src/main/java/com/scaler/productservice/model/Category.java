package com.scaler.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;

    private String description;
    @OneToMany(mappedBy = "categoryName")
    private List<Product> allProducts;
    @OneToMany
    private List<Product> featuredProducts;


}

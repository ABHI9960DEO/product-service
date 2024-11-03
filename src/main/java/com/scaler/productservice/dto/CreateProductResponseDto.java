package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;


    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        product.setId(product.getId());
        product.setTitle(product.getTitle());
        product.setDescription(product.getDescription());
        product.setCategory(product.getCategory());
        product.setPrice(product.getPrice());
        product.setImageUrl(product.getImageUrl());
        return  createProductResponseDto;
    }
}

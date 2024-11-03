package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

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
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        Category category = new Category();
                category.setName(product.getCategoryName().getName());
                responseDto.setCategory(category);
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }
}

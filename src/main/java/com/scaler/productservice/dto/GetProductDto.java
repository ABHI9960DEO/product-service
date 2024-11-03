package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String price;
    private Category category;
    private String description;
    private String image;

    public static GetProductDto fromProduct(Product product) {
        GetProductDto dto = new GetProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        Category category = new Category();
        category.setName(category.getName());
        dto.setCategory(category);
        dto.setDescription(product.getDescription());
        dto.setPrice(String.valueOf(product.getPrice()));
        dto.setImage(product.getImageUrl());

        return dto;
    }
}

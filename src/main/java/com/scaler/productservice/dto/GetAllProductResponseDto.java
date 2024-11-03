package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductResponseDto {

    private String id;
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;


    //GetAllProductResponseDto getAllProductResponseDto;
    //Product product;
    List<GetProductDto> product;

    public  Product fromProduct() {
        Product product = new Product();
        product.setId(Long.valueOf(this.getId()));
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setImageUrl(this.getImage());
        Category category = new Category();
        category.setName(category.getName());
        product.setCategory(category);
        product.setPrice(Double.parseDouble(this.getPrice()));
        return product;

    }
}

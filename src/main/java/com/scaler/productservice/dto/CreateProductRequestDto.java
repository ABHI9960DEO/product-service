package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDto {
    //private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category = new Category();

        category.setName(categoryName.getName());
        product.setCategoryName(category);

        return product;
    }
}

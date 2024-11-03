package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductDto {
    //In this DTO we will give same name of the product as we provided in APIs
    private String title;
    private String description;
    private Category category;
    private String price;
    private String image;

    public static FakeStoreCreateProductDto fromProduct(Product product) {
        FakeStoreCreateProductDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductDto();
        fakeStoreCreateProductRequestDto.title = product.getTitle();
        fakeStoreCreateProductRequestDto.description = product.getDescription();
        Category category = new Category();
        category.setName(product.getCategoryName().getName());
        fakeStoreCreateProductRequestDto.category = category;
        fakeStoreCreateProductRequestDto.price = String.valueOf(product.getPrice());
        fakeStoreCreateProductRequestDto.image = product.getImageUrl();

        return fakeStoreCreateProductRequestDto;
    }
}

package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
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
}

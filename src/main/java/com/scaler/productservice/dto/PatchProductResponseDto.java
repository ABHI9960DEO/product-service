package com.scaler.productservice.dto;

import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductResponseDto {
    GetProductDto product;

//    public Product updateProduct() {
////        Product product = new Product();
////        product.setPrice(getProduct());
//
//        return product;
//    }
}

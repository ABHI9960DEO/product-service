package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
public class FakeStoreGetProductByIdDto {
    private Long id;
    private String title;
    private String price;
    private Category category;
    private String description;
    private String image;

    public static FakeStoreGetProductByIdDto getFakeStoreGetProductByIdDto(Product product) {
        FakeStoreGetProductByIdDto dto = new FakeStoreGetProductByIdDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        Category category = new Category() ;
        dto.setCategory(product.getCategory());
        category.setName(product.getCategory().getName());

        return dto;
    }
}

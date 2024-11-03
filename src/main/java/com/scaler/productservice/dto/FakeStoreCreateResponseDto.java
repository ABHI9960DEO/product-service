package com.scaler.productservice.dto;

import com.scaler.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FakeStoreCreateResponseDto {
    private String id;
    private String title;
    private String description;
    private String image;
    private Category category;
    private String price;
}

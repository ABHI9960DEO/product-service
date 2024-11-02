package com.scaler.productservice.controllers;

import com.scaler.productservice.dto.*;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;
    RestTemplate restTemplate;
    public ProductController(@Qualifier("fakestoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);

        return product;
    }

    @PostMapping("/products/")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();
        //List<GetAllProductResponseDto> getAllProductResponseDtos = new ArrayList<>();
        GetAllProductResponseDto getAllProductResponseDto = new GetAllProductResponseDto();
        List<GetProductDto> getProductDtos = new ArrayList<>();

        for(Product product : products){
            getProductDtos.add(GetProductDto.fromProduct(product));
        }
        getAllProductResponseDto.setProduct(getProductDtos);
        return getAllProductResponseDto;
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long id){
        Product product=productService.updateProduct(id);
        PatchProductResponseDto patchProductResponseDto=new PatchProductResponseDto();
        patchProductResponseDto.setProduct(GetProductDto.fromProduct(product));
        return patchProductResponseDto;
    }
}

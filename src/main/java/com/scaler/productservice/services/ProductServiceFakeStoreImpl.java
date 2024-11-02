package com.scaler.productservice.services;

import com.scaler.productservice.dto.*;
import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreProductService")
public class ProductServiceFakeStoreImpl implements ProductService{

    RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductDto request = new FakeStoreCreateProductDto();
        Category category = new Category();
        //request.setCategory(category.setName(product.getCategory()))  ;
        request.setDescription(product.getDescription());
        request.setImage(product.getImageUrl());
        request.setPrice(String.valueOf(product.getPrice()));

        FakeStoreCreateResponseDto response=restTemplate.postForObject("https://fakestoreapi.com/products/", request, FakeStoreCreateResponseDto.class);

        Product product1=new Product();
        //product1.setCategory(response.getCategory());
        product1.setDescription(response.getDescription());
        product1.setId(Long.valueOf(response.getId()));
        product1.setImageUrl(response.getImage());
        product1.setPrice(Double.parseDouble(response.getPrice()));

        return  product1;
    }

    @Override
    public Product getProduct(Long id) {
        //FakeStoreCreateProductDto request = new FakeStoreCreateProductDto();
        String url="https://fakestoreapi.com/products/"+id;
        FakeStoreGetProductByIdDto getoneProduct=restTemplate.getForObject(url, FakeStoreGetProductByIdDto.class, id);
        Product product1=new Product();
        //product1.setCategory(getoneProduct.getCategory());
        product1.setDescription(getoneProduct.getDescription());
        product1.setId(getoneProduct.getId());
        product1.setImageUrl(getoneProduct.getImage());
        product1.setPrice(Double.parseDouble(getoneProduct.getPrice()));
        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
         String url="https://fakestoreapi.com/products/";
         //GetProductDto[] request=new GetAllProductResponseDto;

        GetAllProductResponseDto[] productsArray=restTemplate.getForObject(url, GetAllProductResponseDto[].class);
        List<Product> products=new ArrayList<>();

        for(GetAllProductResponseDto responseDto:productsArray){
            products.add(responseDto.fromProduct());
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

}

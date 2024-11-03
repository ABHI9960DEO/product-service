package com.scaler.productservice.services;

import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);
    public  Product getProduct(Long id);
    public List<Product> getAllProducts();
    public Product updateProduct(Long id);
    public Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException;
}

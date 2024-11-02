package com.scaler.productservice.services;

import com.scaler.productservice.dto.FakeStoreCreateProductDto;
import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("databaseProductService")
public class ProductServiceDatabaseImpl  implements  ProductService{

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductDto fakeStoreCreateProductDto = new FakeStoreCreateProductDto();
        return product;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }
}

package com.scaler.productservice.services;

import com.scaler.productservice.dto.CreateProductRequestDto;
import com.scaler.productservice.dto.FakeStoreCreateProductDto;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.repository.CategoryRepository;
import com.scaler.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("databaseProductService")
public class ProductServiceDatabaseImpl  implements  ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    ProductServiceDatabaseImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        /*String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;
        if(category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct=categoryRepository.save(toSaveCategory);

            //product.setCategory(categoryRepository.save(toSaveCategory));
        }else{
            toBePutInProduct = category.get();
        }

        product.setCategoryName(toBePutInProduct);

        Product savedProduct = productRepository.save(product);
        return savedProduct;*/
        Category toBePutInProduct = getCategoryToBeInProduct(product);

        product.setCategoryName(toBePutInProduct);

        Product savedProduct = productRepository.save(product);
        System.out.println("hahahhahaha");

        return savedProduct;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException{
        Optional<Product> productToUpdateOptional = productRepository.findById(productId);

        if(productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToUpdate = productToUpdateOptional.get();

        if(product.getDescription()!=null){
            productToUpdate.setDescription(product.getDescription());
        }

        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }

        if(product.getCategoryName()!=null){
            String categoryName=product.getCategoryName().getName();
            Optional<Category> categoryToUpdateOptional = categoryRepository.findByName(categoryName);
            Category categoryToProduct = null;

            if(categoryToUpdateOptional.isEmpty()) {
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                categoryToProduct=categoryRepository.save(newCategory);
            }else{
                categoryToProduct=categoryToUpdateOptional.get();
            }
            productToUpdate.setCategoryName(categoryToProduct);
        }
        return productRepository.save(productToUpdate);
    }

    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategoryName().getName();

        Optional<Category> category =
                categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        if (category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);

            toBePutInProduct = toSaveCategory;
        } else {
            toBePutInProduct = category.get();
        }
        return toBePutInProduct;
    }
}

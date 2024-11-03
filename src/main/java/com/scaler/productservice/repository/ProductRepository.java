package com.scaler.productservice.repository;

import com.scaler.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product product);

    @Override
    void delete(Product product);

    @Override
    public List<Product> findAll();

    @Override
    public Optional<Product> findById(Long id);
}

package com.scaler.productservice.exception;

public class ProductNotFoundException extends  Exception{
    public ProductNotFoundException() {
        super("Product not found");
    }

    public ProductNotFoundException(String message) {
        super(message);  // Allow custom messages for the exception
    }
}

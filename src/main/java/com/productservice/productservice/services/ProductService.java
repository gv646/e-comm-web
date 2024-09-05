package com.productservice.productservice.services;

import com.productservice.productservice.models.Product;

public interface ProductService {

    String getProductById(Long productId);

    void getAllProducts();

    void deleteProductById(Long productId);

    void createProduct();

    void updateProductById();
}

package com.productservice.productservice.services;

import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    @Override
    public String getProductById(Long productId) {
        return "Scaler || Product with id .....@@@@@......" + productId + " found";
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById(Long productId) {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}

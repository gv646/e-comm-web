package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long productId);

    List<GenericProductDto> getAllProducts();

    void deleteProductById(Long productId);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProductById();
}

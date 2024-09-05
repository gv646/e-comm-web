package com.productservice.productservice.controllers;

import com.productservice.productservice.services.FakeStoreProductService;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts(){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }
    
    public void createProduct(){

    }

    public void updateProduct(){

    }
}

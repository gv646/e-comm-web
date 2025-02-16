package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();

    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);

    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);

    }

    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto){
        return productService.updateProductById(id, genericProductDto);

    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        System.out.println("Got product not found exception");
//        return exceptionDto;
//    }

}

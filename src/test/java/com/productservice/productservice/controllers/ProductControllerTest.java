package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Inject
    private ProductController productController;

    @MockBean
    private ProductService productService;



    @Test
    void tesOnePlusOneIsTwoOrNot(){
        assert(2==1+1);
    }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        when(productService.getProductById(100L)).thenReturn(null);

        assertNull(productController.getProductById(100L));

    }
}

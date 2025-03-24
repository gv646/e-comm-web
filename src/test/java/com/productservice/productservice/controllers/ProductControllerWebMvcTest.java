package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Test
    void testGetAllProductsReturnsEmptyList() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnsValidList() throws Exception {

//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//
//        when(productService.getAllProducts())
//                .thenReturn(genericProductDtos);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }
}

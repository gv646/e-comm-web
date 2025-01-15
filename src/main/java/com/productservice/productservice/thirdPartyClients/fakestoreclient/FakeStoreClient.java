package com.productservice.productservice.thirdPartyClients.fakestoreclient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class FakeStoreClient {

    RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreUrl;
    private String pathForProducts;

    private String specificProductUrl;
    private String genericProductUrl;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreUrl,@Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.genericProductUrl = fakeStoreUrl + pathForProducts;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {


        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        //Convert the response to the generic product dto

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }

        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        return List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor,productId);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto updateProductById(Long productId, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(specificProductUrl, HttpMethod.PUT, new HttpEntity<>(genericProductDto), FakeStoreProductDto.class,productId);
        return responseEntity.getBody();

    }

}

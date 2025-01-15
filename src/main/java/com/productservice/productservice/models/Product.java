package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private int price;
    private String image;

    //Category isin't primitive attribute, it's a relation.
    @ManyToOne
    private Category category;
}

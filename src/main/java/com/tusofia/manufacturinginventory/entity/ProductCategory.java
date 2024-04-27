package com.tusofia.manufacturinginventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "product_category")
@Data
public class ProductCategory {
    @Id
    private Long id;

    private String name;

    private String description;
}

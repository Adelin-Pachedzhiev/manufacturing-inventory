package com.tusofia.manufacturinginventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product_unit_of_measure")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitOfMeasure {
    @Id
    private Long id;

    private String unit;

    private String description;
}

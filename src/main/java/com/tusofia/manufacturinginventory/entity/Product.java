package com.tusofia.manufacturinginventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private Boolean canBeSold;

    private Boolean canBePurchased;

    @NotNull(message = "Sales price is required")
    @DecimalMin(value = "0.01", message = "Sales price must be greater than 0")
    private Double salesPrice;

    @NotNull(message = "Cost is required")
    @DecimalMin(value = "0.01", message = "Cost must be greater than 0")
    private Double cost;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @ManyToOne
    private UnitOfMeasure unitOfMeasure;

    @Size(min = 12 ,max = 13, message = "Barcode should have a size of 12 or 13")
    private String barcode;

    @ManyToOne
    private ProductCategory category;
}

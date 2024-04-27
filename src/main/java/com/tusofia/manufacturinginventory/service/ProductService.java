package com.tusofia.manufacturinginventory.service;

import com.tusofia.manufacturinginventory.entity.Product;
import com.tusofia.manufacturinginventory.entity.ProductCategory;
import com.tusofia.manufacturinginventory.entity.UnitOfMeasure;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    List<ProductCategory> getAllCategories();
    List<UnitOfMeasure> getUnitsOfMeasure();

    void saveProduct(Product product);

    void deleteProduct(Long id);
    Optional<Product> getProductById(Long id);
}

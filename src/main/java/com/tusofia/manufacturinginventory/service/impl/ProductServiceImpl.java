package com.tusofia.manufacturinginventory.service.impl;

import com.tusofia.manufacturinginventory.entity.Product;
import com.tusofia.manufacturinginventory.entity.ProductCategory;
import com.tusofia.manufacturinginventory.entity.UnitOfMeasure;
import com.tusofia.manufacturinginventory.repository.ProductCategoryRepository;
import com.tusofia.manufacturinginventory.repository.ProductRepository;
import com.tusofia.manufacturinginventory.repository.UnitOfMeasureRepository;
import com.tusofia.manufacturinginventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<UnitOfMeasure> getUnitsOfMeasure() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}

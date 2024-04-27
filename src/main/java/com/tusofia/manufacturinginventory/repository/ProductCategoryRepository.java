package com.tusofia.manufacturinginventory.repository;

import com.tusofia.manufacturinginventory.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}

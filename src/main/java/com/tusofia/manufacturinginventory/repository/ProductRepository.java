package com.tusofia.manufacturinginventory.repository;

import com.tusofia.manufacturinginventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

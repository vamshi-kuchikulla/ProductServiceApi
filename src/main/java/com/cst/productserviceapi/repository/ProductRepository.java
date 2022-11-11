package com.cst.productserviceapi.repository;

import com.cst.productserviceapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

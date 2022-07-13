package com.coding.IntegrationTesting.repository;

import com.coding.IntegrationTesting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

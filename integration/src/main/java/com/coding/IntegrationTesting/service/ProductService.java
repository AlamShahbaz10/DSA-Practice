package com.coding.IntegrationTesting.service;

import com.coding.IntegrationTesting.entity.Product;
import com.coding.IntegrationTesting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;


    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> list = repo.findAll();
        return list;
    }
}

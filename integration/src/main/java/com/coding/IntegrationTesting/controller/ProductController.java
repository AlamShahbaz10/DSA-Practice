package com.coding.IntegrationTesting.controller;

import com.coding.IntegrationTesting.entity.Product;
import com.coding.IntegrationTesting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
}

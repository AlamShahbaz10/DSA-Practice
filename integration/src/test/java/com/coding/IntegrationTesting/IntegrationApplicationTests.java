package com.coding.IntegrationTesting;

import com.coding.IntegrationTesting.entity.Product;
import com.coding.IntegrationTesting.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class IntegrationApplicationTests {

	private static RestTemplate restTemplate;

	@BeforeAll
	public static void init(){
		restTemplate = new RestTemplate();
	}

	@Autowired
	private ProductRepository repo;

	@Test
	public void testAddProduct() {
		Product product = new Product("Mobile", 1, 10000);
		Product response = restTemplate.postForObject("http://localhost:8080/products", product, Product.class);
		Assertions.assertEquals("Mobile", response.getName());

	}

}

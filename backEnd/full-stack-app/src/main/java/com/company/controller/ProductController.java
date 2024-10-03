package com.company.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.model.Product;
import com.company.service.ProductService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		logger.info("Fetching all products");
		return productService.getProducts();
	}
	
	@PostMapping("/products")
	public Product postProducts(@Validated @RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		
		 return productService.getProduct(productId)
		            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable Long id, @Validated @RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value = "id") Long productId) {
		productService.deleteProduct(productId);
	}

}

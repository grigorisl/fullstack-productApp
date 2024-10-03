package com.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Product;
import com.company.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	private NextSequenceService nextSequenceService;

	@Override
	public List<Product> getProducts() {	
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Long id) {		
		return productRepository.findById(id);
	}

	@Override
	public Product createProduct(Product product) {

		Long id = nextSequenceService.getNextSequence("customSequence"); // Get next sequence ID synchronously
        product.setId(id);
        return productRepository.save(product); // Save product and return it
	}

	@Override
	public Product updateProduct(Product product) {
		
		return productRepository.findById(product.getId())
	            .map(existingProduct -> {
	                existingProduct.setProductName(product.getProductName());
	                existingProduct.setPrice(product.getPrice());
	                existingProduct.setProductDesc(product.getProductDesc());
	                return productRepository.save(existingProduct); // Update and return the saved product
	            })
	            .orElseThrow(() -> new RuntimeException("Product not found")); // Handle product not found
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}

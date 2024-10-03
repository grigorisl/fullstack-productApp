package com.company.service;

import java.util.List;
import java.util.Optional;
import com.company.model.Product;


public interface ProductService {
	
	
	List<Product> getProducts();
	Optional<Product> getProduct(Long id);
	Product createProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Long id);

}

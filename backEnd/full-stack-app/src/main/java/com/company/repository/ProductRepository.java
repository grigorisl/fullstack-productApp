package com.company.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}

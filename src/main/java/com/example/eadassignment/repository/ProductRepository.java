package com.example.eadassignment.repository;

import com.example.eadassignment.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}

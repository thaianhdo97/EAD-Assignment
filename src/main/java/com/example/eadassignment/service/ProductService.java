package com.example.eadassignment.service;

import com.example.eadassignment.dto.ProductDTO;
import com.example.eadassignment.entity.Product;
import com.example.eadassignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {
        Product student = new Product(productDTO);
        return productRepository.save(student);
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }
}

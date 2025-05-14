package com.example.orderservice.service;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductClient productClient;

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProduct")
    public ProductDTO getProduct(Long id) {
        return productClient.getProductById(id);
    }

    public ProductDTO fallbackGetProduct(Long id, Throwable throwable) {
        System.out.println("⚠️ Product service failed: " + throwable.getMessage());
        return new ProductDTO(id, "Fallback Product", 0.0);
    }
}


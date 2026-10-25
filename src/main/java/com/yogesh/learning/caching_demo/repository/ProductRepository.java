package com.yogesh.learning.caching_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yogesh.learning.caching_demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

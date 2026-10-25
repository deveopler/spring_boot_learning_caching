package com.yogesh.learning.caching_demo.service;

import org.springframework.stereotype.Service;
import com.yogesh.learning.caching_demo.repository.ProductRepository;
import com.yogesh.learning.caching_demo.entity.Product;
import com.yogesh.learning.caching_demo.exception.ProductNotFoundException;

@Service 
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductById(Long id) {
        System.out.println("Fetching product with id: " + id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        System.out.println("Created product: " + savedProduct);
        return savedProduct;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        System.out.println("Updating product with id: " + id);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        System.out.println("Deleting product with id: " + id);
        productRepository.deleteById(id);
    }
    public Iterable<Product> getAllProducts() {
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }
}

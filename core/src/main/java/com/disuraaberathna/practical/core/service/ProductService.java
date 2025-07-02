package com.disuraaberathna.practical.core.service;

import com.disuraaberathna.practical.core.model.Product;
import jakarta.ejb.Remote;

import java.util.List;
import java.util.Optional;

@Remote
public interface ProductService {
    Optional<Product> getProductById(long id);

    Optional<Product> getProductByName(String name);

    List<Product> getProductsByCategory(String category);

    List<Product> getAllProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}

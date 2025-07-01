package com.disuraaberathna.practical.core.service;

import com.disuraaberathna.practical.core.model.Product;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ProductService {
    Product getProductById(long id);

    Product getProductByName(String name);

    List<Product> getProductsByCategory(String category);

    List<Product> getAllProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long id);
}

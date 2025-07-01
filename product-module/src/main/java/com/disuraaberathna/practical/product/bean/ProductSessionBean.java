package com.disuraaberathna.practical.product.bean;

import com.disuraaberathna.practical.core.model.Product;
import com.disuraaberathna.practical.core.service.ProductService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProductSessionBean implements ProductService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Product getProductById(long id) {
        return em.find(Product.class, id);
    }

    @Override
    public Product getProductByName(String name) {
        try {
            return em.createNamedQuery("Product.findByName", Product.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        try {
            return em.createNamedQuery("Product.findByCategory", Product.class).setParameter("category", category).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public void addProduct(Product product) {
        em.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);
    }

    @Override
    public void deleteProduct(long id) {
        em.remove(getProductById(id));
    }
}

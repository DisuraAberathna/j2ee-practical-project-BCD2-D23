package com.disuraaberathna.practical.product.bean;

import com.disuraaberathna.practical.core.model.Product;
import com.disuraaberathna.practical.core.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductSessionBean implements ProductService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Product> getProductById(long id) {
//        return em.find(Product.class, id);
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        try {
            TypedQuery<Product> query = em.createNamedQuery("Product.findByName", Product.class).setParameter("name", name);
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
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

    //    @RolesAllowed({"SUPER_ADMIN", "ADMIN"})
    @Override
    public void deleteProduct(Long id) {
        if (id == null || id < 0) {
            throw new InvalidParameterException("Product id is null or negative");
        }
        em.remove(getProductById(id));
    }
}

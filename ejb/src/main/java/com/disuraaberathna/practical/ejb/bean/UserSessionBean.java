package com.disuraaberathna.practical.ejb.bean;

import com.disuraaberathna.practical.core.model.User;
import com.disuraaberathna.practical.core.service.UserService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserSessionBean implements UserService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        return em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean validateUser(String email, String password) {
//        User user = em.createNamedQuery("User.findByEmail", User.class)
//                .setParameter("email", email)
//                .getSingleResult();
//        return user != null && user.getPassword().equals(password);

        User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        return user != null;
    }
}

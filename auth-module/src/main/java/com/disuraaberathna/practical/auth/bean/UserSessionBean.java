package com.disuraaberathna.practical.auth.bean;

import com.disuraaberathna.practical.core.model.User;
import com.disuraaberathna.practical.core.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
        try {
            return em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @RolesAllowed({"SUPER_ADMIN", "ADMIN", "USER"})
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @RolesAllowed({"SUPER_ADMIN", "ADMIN", "USER"})
    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean validateUser(String email, String password) {
        try {
//        User user = em.createNamedQuery("User.findByEmail", User.class)
//                .setParameter("email", email)
//                .getSingleResult();
//        return user != null && user.getPassword().equals(password);

            User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return user != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}

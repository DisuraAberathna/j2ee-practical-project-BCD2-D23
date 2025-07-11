package com.disuraaberathna.practical.core.service;

import com.disuraaberathna.practical.core.model.User;
import jakarta.ejb.Remote;

@Remote
public interface UserService {
    User getUser(long id);

    User getUserByEmail(String email);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    boolean validateUser(String email, String password);

    void verifyUser(User user);
}

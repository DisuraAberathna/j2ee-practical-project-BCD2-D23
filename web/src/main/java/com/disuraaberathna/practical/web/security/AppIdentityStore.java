package com.disuraaberathna.practical.web.security;

import com.disuraaberathna.practical.core.model.User;
import com.disuraaberathna.practical.core.service.UserService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {
    @EJB
    private UserService userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential upc){
            if (userService.validateUser(upc.getCaller(), upc.getPasswordAsString())){
                User user = userService.getUserByEmail(upc.getCaller());

                return new CredentialValidationResult(user.getEmail(), Set.of(user.getUserType().name()));
            }
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}

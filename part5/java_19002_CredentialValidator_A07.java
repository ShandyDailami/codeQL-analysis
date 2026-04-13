// Package
package com.example.credentialvalidator;

// Import necessary classes
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Credential Validator Class
public class java_19002_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    // Data to store users
    private Map<String, String> users = new HashMap<>();

    // Constructor
    public java_19002_CredentialValidator_A07() {
        // Add example users to the map
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    // Method to validate credentials
    public Subject validate(Subject subject, Credential credential) throws AccessControlException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier());

        if (users.containsKey(username) && users.get(username).equals(password)) {
            return subject;
        } else {
            throw new AccessControlException("Access denied");
        }
    }

    // Callback Handler
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            public void callback(Callback callback[]) throws IOException, UnsupportedCallbackException {
                // Do Nothing
            }

            public Subject getSubject(Callback callback[]) throws IOException, UnsupportedCallbackException {
                return null;
            }
        };
    }
}
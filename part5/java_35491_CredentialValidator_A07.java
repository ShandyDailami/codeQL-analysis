// Package statement
package com.example.auth;

// Import statements
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Credential Validator interface
public interface CredentialValidator {
    boolean isValid(String username, String password);
}

// Credential Authenticator
public class java_35491_CredentialValidator_A07 {
    private final CredentialValidator validator;

    public java_35491_CredentialValidator_A07(CredentialValidator validator) {
        this.validator = validator;
    }

    public boolean authenticate(String username, String password) {
        if (validator.isValid(username, password)) {
            System.out.println("Authentication successful for user: " + username);
            return true;
        } else {
            System.out.println("Authentication failed for user: " + username);
            return false;
        }
    }
}

// Username and Password list
List<String> validUsers = Arrays.asList("user1", "user2", "user3");
List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

// CredentialValidator implementation
public class CustomCredentialValidator implements CredentialValidator {
    @Override
    public boolean isValid(String username, String password) {
        return validUsers.contains(username) && validPasswords.contains(password);
    }
}

// Test CredentialAuthenticator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator();
        CredentialAuthenticator authenticator = new CredentialAuthenticator(validator);

        // Test cases
        authenticator.authenticate("user1", "password1"); // should print "Authentication successful for user: user1"
        authenticator.authenticate("user4", "password1"); // should print "Authentication failed for user: user4"
        authenticator.authenticate("user1", "wrongPassword"); // should print "Authentication failed for user: user1"
    }
}
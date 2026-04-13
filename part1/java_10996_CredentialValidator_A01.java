// Package declaration
package com.example.security;

import java.util.Base64;
import java.util.Map;

public class java_10996_CredentialValidator_A01 {

    // The method below serves as the entry point of the validation process
    public ValidationResult validate(Map<String, String> credentials) {
        String user = credentials.get("username");
        String password = credentials.get("password");

        // The password is hashed for security reasons. Here we use a simple hashing process
        String hashedPassword = hashPassword(password);

        // Check if the username and password are correct
        if (user.equals("admin") && hashedPassword.equals("hash")) {
            return new ValidationResult(true, "Authentication successful");
        } else {
            return new ValidationResult(false, "Invalid username or password");
        }
    }

    // A helper method to hash passwords for security reasons
    private String hashPassword(String password) {
        byte[] hashedBytes = hashPassword(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    // A helper method to hash passwords for security reasons
    private byte[] hashPassword(byte[] password) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password);
        return md.digest();
    }
}
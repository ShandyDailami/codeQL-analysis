import java.security.InvalidParameterException;
import java.util.Base64;

import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_02187_CredentialValidator_A01 {

    public static void main(String[] args) {
        try {
            validate("user", "password");
            System.out.println("Credentials are valid.");
        } catch (Exception e) {
            System.out.println("Invalid credentials: " + e.getMessage());
        }
    }

    public static void validate(String user, String password) throws CredentialException, LoginException {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }
        
        UsernamePasswordCredential credential = new UsernamePasswordCredential(user, password.getBytes());
        javax.security.auth.AuthPermission perm = new javax.security.auth.AuthPermission("act as");
        perm.setUser();
        javax.security.auth.Subject subject = new javax.security.auth.Subject("Java Example", perm, credential);
        if (subject.getPrincipal() == null) {
            throw new CredentialException("Authentication failed");
        }
    }
}
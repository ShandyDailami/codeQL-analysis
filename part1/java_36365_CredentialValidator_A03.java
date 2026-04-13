import java.security.Provider;
import java.security.Security;
import java.security.AccessController;
import java.lang.RuntimePermission;

import java.security.Permission;
import java.lang.reflect.Method;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_36365_CredentialValidator_A03 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            validateCredentials(USERNAME, PASSWORD);
            System.out.println("Validated successfully!");
        } catch (Exception e) {
            System.out.println("Error validating credentials: " + e.getMessage());
        }
    }

    public static void validateCredentials(String username, String password) throws Exception {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials match!");
        } else {
            throw new Exception("Invalid username or password");
        }
    }
}
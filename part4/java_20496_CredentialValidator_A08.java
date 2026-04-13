import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Iterator;

public class java_20496_CredentialValidator_A08 {

    public static void main(String[] args) {
        try {
            // Create a Credential Validator
            CredentialValidator credentialValidator = new CredentialValidator();
            // Validate the credential
            boolean isValid = credentialValidator.validateCredentials("username", "password");
            System.out.println("Is Valid? " + isValid);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username and password are not null
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        // Check if the username and password are not empty
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        // Check if the username is insecure
        if (isUsernameInsecure(username)) {
            throw new IllegalArgumentException("Username is insecure");
        }

        // Check if the password is insecure
        if (isPasswordInsecure(password)) {
            throw new IllegalArgumentException("Password is insecure");
        }

        // If all checks are passed, return true
        return true;
    }

    private boolean isUsernameInsecure(String username) {
        // Implementation of username insecurity check
        // This is just a dummy implementation
        return username.endsWith("$");
    }

    private boolean isPasswordInsecure(String password) {
        // Implementation of password insecurity check
        // This is just a dummy implementation
        return password.contains("password");
    }
}
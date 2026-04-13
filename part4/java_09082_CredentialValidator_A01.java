import java.security.InvalidParameterException;

public class java_09082_CredentialValidator_A01 {
    public boolean validateCredential(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }
        
        if (username.isEmpty() || password.isEmpty()) {
            throw new InvalidParameterException("Username and password must not be empty");
        }

        // Here you can add more complex validation logic based on your application
        // For now, we just return true to simulate a valid credential
        return true;
    }
}
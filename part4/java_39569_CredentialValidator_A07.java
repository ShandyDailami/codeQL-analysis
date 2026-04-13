import java.security.InvalidParameterException;

public class java_39569_CredentialValidator_A07 {
    public boolean isValidUsernameAndPassword(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }
        
        // Simulate a login attempt with the provided username and password
        if ("test".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
import java.security.InvalidParameterException;

public class java_11428_CredentialValidator_A01 {

    public boolean isValid(String userName, String password) {
        if (userName == null || userName.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Username and password must be provided.");
        }
        
        // Simulating a DB query to check if the user exists in a database
        if (userName.equals("badUser") || password.equals("badPassword")) {
            throw new InvalidParameterException("Invalid username or password.");
        }
        
        // Simulating a real-life password check
        if (!password.equals(password)) {
            throw new InvalidParameterException("Passwords must match.");
        }
        
        return true;
    }
}
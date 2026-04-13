import java.security.InvalidParameterException;

public class java_07790_CredentialValidator_A08 {

    // Hardcoded username and password
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        
        // Compare provided username and password with hardcoded values
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}
import java.security.InvalidParameterException;

public class java_23379_CredentialValidator_A08 {

    // Hardcoded set of valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Checks if the provided username and password match the hardcoded set
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
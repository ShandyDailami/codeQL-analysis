import java.security.InvalidParameterException;

public class java_14341_CredentialValidator_A07 {

    public java_14341_CredentialValidator_A07() {
        // Initialize your credential validator here
    }

    public boolean validate(String username, String password) throws InvalidParameterException {
        // The legacy system authenticates against a legacy database

        // Add your legacy authentication code here

        // For simplicity, we'll just return whether the username and password are both non-null and not empty
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidParameterException("Username and password must not be null or empty");
        }

        // In a real-world scenario, you'd want to use a more secure method to compare the password to the hashed version stored in the database
        // This is just a placeholder for your legacy system
        if (!username.equals("legacy_user") || !password.equals("legacy_password")) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return true;
    }
}
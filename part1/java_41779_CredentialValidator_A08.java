import java.security.InvalidParameterException;

public class java_41779_CredentialValidator_A08 {
    public boolean validate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        // Continue with the rest of your code here

        return true; // Indicate that the credential is valid
    }
}
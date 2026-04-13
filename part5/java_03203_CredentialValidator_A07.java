import java.util.Arrays;
import java.util.List;

public class java_03203_CredentialValidator_A07 {

    // List of accepted passwords
    private List<String> acceptedPasswords = Arrays.asList("password", "admin", "user", "1234", "admin123");

    // Method to validate password
    public boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is null or empty");
        }

        return acceptedPasswords.contains(password);
    }
}
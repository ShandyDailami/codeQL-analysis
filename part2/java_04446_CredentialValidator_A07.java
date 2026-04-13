import java.security.InvalidParameterException;
import java.util.Arrays;

public class java_04446_CredentialValidator_A07 {

    // Define the set of valid passwords
    private static final String[] VALID_PASSWORDS = {"password", "secret", "123456", "test123", "admin123"};

    // Define the length of the passwords
    private static final int PASSWORD_LENGTH = 6;

    // Validate password
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() != PASSWORD_LENGTH) {
            throw new InvalidParameterException("Invalid password length");
        }

        return Arrays.asList(VALID_PASSWORDS).contains(password);
    }

    // Main method
    public static void main(String[] args) {
        // Test the validation
        System.out.println(isValidPassword("password") ? "Valid password" : "Invalid password");
        System.out.println(isValidPassword("123456") ? "Valid password" : "Invalid password");
        System.out.println(isValidPassword("test123") ? "Valid password" : "Invalid password");
        System.out.println(isValidPassword("admin123") ? "Valid password" : "Invalid password");
        System.out.println(isValidPassword("invalid") ? "Valid password" : "Invalid password");
    }
}
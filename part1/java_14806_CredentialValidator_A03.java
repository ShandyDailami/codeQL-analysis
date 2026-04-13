import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class java_14806_CredentialValidator_A03 {

    // Define a list of valid passwords
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    // Simple method to check if a password is valid
    public boolean isValidPassword(String password) {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);
        return VALID_PASSWORDS.contains(decodedPassword);
    }

    // Simple method to check if a username is valid
    public boolean isValidUsername(String username) {
        // You can perform any username validation here, e.g., check if it contains a special character, etc.
        // For now, we just return true if the username is "admin"
        return "admin".equals(username);
    }

    // Main method to validate credentials
    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}
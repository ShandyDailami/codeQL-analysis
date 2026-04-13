import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class java_11655_CredentialValidator_A03 {

    // Validate if the username is valid
    public static boolean validateUsername(String username) {
        // Simple validation: username is not empty and has at least 4 characters
        return !(username == null || username.trim().isEmpty() || username.length() < 4);
    }

    // Validate if the password is valid
    public static boolean validatePassword(String password) {
        // Simple validation: password is not empty and has at least 8 characters
        return !(password == null || password.trim().isEmpty() || password.length() < 8);
    }

    // Main method to validate credentials
    public static boolean validate(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }

}
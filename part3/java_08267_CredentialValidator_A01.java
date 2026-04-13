import java.util.Arrays;
import java.util.List;

public class java_08267_CredentialValidator_A01 {
    // List of valid usernames and passwords
    private static final List<String> validUsers = Arrays.asList("user1", "user2", "admin");
    private static final List<String> validPasswords = Arrays.asList("password1", "password2", "adminpassword");

    // Method to validate the credentials
    public static boolean validate(String username, String password) {
        if (validUsers.contains(username) && validPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Test the method
    public static void main(String[] args) {
        // Test credentials
        System.out.println("Is valid: " + validate("user1", "password1"));
        System.out.println("Is valid: " + validate("admin", "adminpassword"));
        System.out.println("Is valid: " + validate("invalid", "invalid"));
    }
}
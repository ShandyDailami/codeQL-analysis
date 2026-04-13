import java.security.Security;
import java.util.Arrays;
import java.util.List;

public class java_05396_CredentialValidator_A08 {

    // A list of common passwords (not secure!)
    private static final List<String> WEAK_PASSWORDS = Arrays.asList("password", "abc", "qwerty");

    public static boolean validate(String password) {
        // If the password is in the list of weak passwords, return false
        if (WEAK_PASSWORDS.contains(password)) {
            return false;
        }

        // If the password is null or empty, return false
        if (password == null || password.isEmpty()) {
            return false;
        }

        // If the password is too weak, return false
        if (password.length() < 8) {
            return false;
        }

        // If the password contains a weak character (like '1', 'l', '0'), return false
        if (password.matches(".*[1l0].*")) {
            return false;
        }

        // If none of the above conditions are met, the password is considered secure
        return true;
    }

    public static void main(String[] args) {
        // Test the validate method with some passwords
        List<String> passwords = Arrays.asList("password", "abc", "qwerty", "12345678", "11111111", "");
        for (String password : passwords) {
            boolean isValid = validate(password);
            System.out.println("Password: " + password + ", Is Valid: " + isValid);
        }
    }
}
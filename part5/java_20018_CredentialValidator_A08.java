import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_20018_CredentialValidator_A08 implements CredentialValidator {

    // Common password list
    private static final Set<String> COMMON_PASSWORDS = new HashSet<>(Arrays.asList("123456", "password", "admin", "qwerty"));

    @Override
    public boolean validate(String username, String password) {
        // Check if password is in common password list
        if (COMMON_PASSWORDS.contains(password)) {
            System.out.println("Password is common!");
            return false;
        }

        // Check if password is too weak
        if (password.length() < 8) {
            System.out.println("Password is too weak!");
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one number and one special character
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*[0-9].*")) || !(password.matches(".*[!@#$%^&*()_+\\-=\\[{\\]\\};:?,.<>].*"))) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one number and one special character!");
            return false;
        }

        // If none of the checks fail, return true
        return true;
    }
}
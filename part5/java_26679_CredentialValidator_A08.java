import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26679_CredentialValidator_A08 {

    public static boolean isPasswordStrong(String password) {
        // Check if password is too short or too long
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one digit and one special character
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
            return false;
        }

        // Check if password contains non-alphanumeric character
        if (!password.matches("^(?=.*[^a-zA-Z0-9]).+$")) {
            return false;
        }

        // Check if password contains two repeating characters
        if (!password.matches("^(?=.*(\\s.\\s)).+$")) {
            return false;
        }

        // If all checks passed, the password is strong
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "ThisIsAStrongPassword";
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}
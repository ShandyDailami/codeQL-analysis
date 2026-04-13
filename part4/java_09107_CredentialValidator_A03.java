import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09107_CredentialValidator_A03 {
    public static boolean isPasswordStrong(String password) {
        // Checking if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Checking if password contains a sequence of numbers or special characters
        if (password.matches(".*[0-9].*") || password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?\\|`~].*")) {
            return false;
        }

        // Checking if password contains a sequence of repeating characters
        if (password.matches(".*(.)\\1.*")) {
            return false;
        }

        // If all checks pass, password is strong
        return true;
    }

    public static void main(String[] args) {
        String password = "strongpassword";
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}
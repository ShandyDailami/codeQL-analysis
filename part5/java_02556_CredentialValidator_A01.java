import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_02556_CredentialValidator_A01 {
    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // Check if password is strong enough (contains uppercase, lowercase, numbers, and special characters)
        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*"))) {
            return false;
        }

        // Hash password using SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));

            // Check if password has a high strength
            if (hash.length > 128) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        String password = "ThisIsAFakePassword"; // Change this to test the password
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}
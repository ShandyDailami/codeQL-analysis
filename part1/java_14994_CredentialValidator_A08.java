import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_14994_CredentialValidator_A08 {

    // User class for storing user data
    public static class User {
        private String username;
        private String password;

        public java_14994_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // Method for hashing passwords
    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // CredentialValidator method to validate user credentials
    public static boolean validateCredentials(User user, String password) {
        return user.getPassword().equals(hashPassword(password));
    }

    public static void main(String[] args) {
        // Create a User object and validate its password
        User user = new User("admin", "password123");
        boolean isValid = validateCredentials(user, "wrongPassword");
        System.out.println("Invalid Credentials: " + isValid);

        isValid = validateCredentials(user, "password123");
        System.out.println("Valid Credentials: " + isValid);
    }
}
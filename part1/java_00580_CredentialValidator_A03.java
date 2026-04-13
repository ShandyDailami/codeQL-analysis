import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_00580_CredentialValidator_A03 {

    private static final String ALGORITHM = "SHA-256";

    public boolean isValid(String username, String password) {
        User user = findUser(username);

        if (user == null) {
            return false;
        }

        return isValidPassword(password, user.getPassword());
    }

    private User findUser(String username) {
        // This method should connect to the database and fetch the user from there.
        // This is just a placeholder and won't work in this context.
        return null;
    }

    private boolean isValidPassword(String password, String hashedPassword) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash).equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // This is a test user. In a real-world scenario, you would likely fetch this from a database.
        User testUser = new User("testUser", "testPassword", "admin");

        boolean isValid = validator.isValid("testUser", "testPassword");
        if (isValid) {
            System.out.println("Credentials are valid for user: " + testUser.getUsername());
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private class User {
        private String username;
        private String password;
        private String role;

        public java_00580_CredentialValidator_A03(String username, String password, String role) {
            this.username = username;
            this.password = hashPassword(password);
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }

        private String hashPassword(String password) {
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance(ALGORITHM);
                byte[] hash = digest.digest(password.getBytes());
                return Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("SHA-256 algorithm not available");
            }
        }
    }
}
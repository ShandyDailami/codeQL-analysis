import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_11448_CredentialValidator_A01 {

    // User details
    private String username;
    private String password;

    // Stored user details
    private String storedUsername;
    private String storedPassword;

    // Create a user with a password
    public java_11448_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    // Check if the entered password matches the hashed password
    public boolean authenticate(String enteredPassword) {
        return hashPassword(enteredPassword).equals(this.password);
    }

    // Hash the password
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");

        if (validator.authenticate("wrongPassword")) {
            System.out.println("Wrong password");
        } else if (validator.authenticate("password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}
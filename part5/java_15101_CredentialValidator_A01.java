import java.util.Base64;
import java.util.Base64.Decoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_15101_CredentialValidator_A01 {

    private static final String SALT = "SALT"; // Add a salt for added security

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);

        // Here you would usually query your database for a user with this username
        // and check if the hashed password matches. For simplicity, we're just comparing
        // the hashed passwords.

        // For A01_BrokenAccessControl:
        return hashedPassword.equals(hashedPassword(username));
    }

    private String hashPassword(String password) {
        String saltedPassword = password + SALT;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(saltedPassword.getBytes());

            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // For A01_BrokenAccessControl:
    private String hashedPassword(String username) {
        return username + SALT; // return a hashed version of the username and salt
    }

}
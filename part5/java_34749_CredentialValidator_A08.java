import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_34749_CredentialValidator_A08 {

    private static final String SALT = "salt"; // Adding a salt to the password for security

    public boolean validate(String username, String password) {
        try {
            String hashedPassword = hashPassword(password + SALT);
            // In a real scenario, you would have a database with all the valid usernames and their hashed passwords
            // Here, we are just checking if the provided password and salt match
            return hashedPassword.equals(hashPassword(password + SALT));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }
}
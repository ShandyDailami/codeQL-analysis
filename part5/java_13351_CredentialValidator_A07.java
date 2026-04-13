import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_13351_CredentialValidator_A07 {

    public static final String SALT = "salt";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String hashedPassword = hashPassword(password, SALT);

        // Here, you would typically fetch the user's hashed password from your database.
        // If the hashed password from the database is the same as the hashed password we just created,
        // we return true. Otherwise, we return false.

        return true;
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
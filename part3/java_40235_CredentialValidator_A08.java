import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40235_CredentialValidator_A08 {

    private static final String SALT = "this_is_salt"; // this should be random for each user

    // Method to hash password with salt
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8") + SALT.getBytes("UTF-8"));
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    // Method to validate password
    public boolean validatePassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}
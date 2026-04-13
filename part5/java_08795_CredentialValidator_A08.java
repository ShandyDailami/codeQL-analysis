import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_08795_CredentialValidator_A08 {

    private static final String SALT = "SALT"; // This is a random string that is added to the password

    public static String hashPassword(String password) {
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

    public static boolean validatePassword(String password, String hashedPassword) {
        String hashedInput = hashPassword(password + SALT);
        return hashedInput.equals(hashedPassword);
    }
}
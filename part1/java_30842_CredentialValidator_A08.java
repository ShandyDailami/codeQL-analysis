import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_30842_CredentialValidator_A08 {
    private static final String SALT = "salt"; // This should be randomly generated for each user

    public static String hashPassword(String password, String salt) {
        String hash;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String toHash = password + SALT;
            byte[] hashBytes = md.digest(toHash.getBytes());
            hash = Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hash;
    }

    public static boolean validate(String passwordAttempt, String storedPassword, String salt) {
        String hashedAttempt = hashPassword(passwordAttempt, salt);
        return hashedAttempt.equals(storedPassword);
    }
}
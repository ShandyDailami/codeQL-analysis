import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_17007_CredentialValidator_A08 {

    private static final String SALT = "A08_IntegrityFailure";

    public static boolean validatePassword(String password, String hashedPassword) {
        String hashedInput = hashPassword(password, SALT);
        return hashedInput.equals(hashedPassword);
    }

    private static String hashPassword(String password, String salt) {
        String saltedPassword = password + salt;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String password = "test";
        String hashedPassword = hashPassword(password, SALT);

        boolean isValid = validatePassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}
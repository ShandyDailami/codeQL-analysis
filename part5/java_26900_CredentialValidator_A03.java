import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_26900_CredentialValidator_A03 {
    private static final String HASHED_PASSWORD = "pbkdf2:sha256:10000:(some_password)"; // this is just an example, you should use the actual hash

    public static void main(String[] args) {
        String userPassword = "myPassword";
        if (isValid(userPassword)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }

    private static boolean isValid(String userPassword) {
        try {
            String hashedPassword = hashPassword(userPassword);
            return hashedPassword.equals(HASHED_PASSWORD);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}
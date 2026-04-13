import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_07326_CredentialValidator_A08 {
    public static boolean validateCredentials(String userName, String password) {
        // We should never store passwords in plain text
        // You can use a hashing algorithm like SHA-256 or Bcrypt to store hashed passwords
        // In this example, we will just compare the password in plain text with a fixed string

        String hashedPassword = "d915e9a985a3b4a01029e9a985b1e9b102b4a01029e9a985b1e9b102b4a0102";

        return hashPassword(password).equals(hashedPassword);
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        byte[] hashBytes;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
       
        }
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}
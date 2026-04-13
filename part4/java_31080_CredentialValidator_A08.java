import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class java_31080_CredentialValidator_A08 {

    private static final String SECRET = "my-secret-key"; // A secret key should never be hardcoded

    // Method to validate the password
    public boolean validate(String passwordAttempt, String encryptedPassword) throws NoSuchAlgorithmException, InvalidKeySpec {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey secretKey = secretKeyFactory.createKey(SECRET.getBytes());

        // Attempt to decrypt the password using the same secret key
        byte[] decodedPassword = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedPassword = secretKey.doFinal(decodedPassword);

        // Compare the decrypted password with the password attempt
        return passwordAttempt.equals(new String(decryptedPassword));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        CredentialValidator validator = new CredentialValidator();

        String passwordAttempt = "password123";
        String encryptedPassword = "$2a$10$EIXMKjUWoqU2ByMi1npZY.jQ3b.YF30.J8jK3.jV.ZYF3L3bQD36I7"; // This is a hardcoded example

        if (validator.validate(passwordAttempt, encryptedPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Invalid password.");
        }
    }
}
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_40832_CredentialValidator_A08 {

    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user1", "password1");
        validator.validate("user2", "password2");
    }

    public void validate(String username, String password) throws NoSuchAlgorithmException {
        String hashedPassword = hashPassword(password);
        if (username.equals("user1") && hashedPassword.equals("password1")) {
            System.out.println("Access granted for user1");
        } else if (username.equals("user2") && hashedPassword.equals("password2")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied");
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
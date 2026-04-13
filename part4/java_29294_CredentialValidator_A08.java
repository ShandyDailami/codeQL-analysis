import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_29294_CredentialValidator_A08 {

    private static final String SALT = "salt";
    private MessageDigest messageDigest;

    public java_29294_CredentialValidator_A08() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSalt() {
        return Base64.getEncoder().encodeToString(messageDigest.digest(SALT.getBytes()));
    }

    public String createHash(String password, String salt) {
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public boolean validate(String enteredPassword, String salt, String storedHash) {
        String hash = createHash(enteredPassword, salt);
        return hash.equals(storedHash);
    }
}
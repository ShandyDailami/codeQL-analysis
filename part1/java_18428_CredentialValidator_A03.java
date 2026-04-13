import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PasswordAuthentication;
import java.util.Base64;

public class java_18428_CredentialValidator_A03 implements CredentialValidator {

    private static final String SHA_256 = "SHA-256";
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";
    private static final String HASHED_PASSWORD = getHashedPassword(PASSWORD);

    private static String getHashedPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(SHA_256);
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PasswordAuthentication validatePassword(String enteredPassword) {
        if (getHashedPassword(enteredPassword).equals(HASHED_PASSWORD)) {
            return new PasswordAuthentication(USER_NAME, null, null);
        } else {
            return null;
        }
    }
}
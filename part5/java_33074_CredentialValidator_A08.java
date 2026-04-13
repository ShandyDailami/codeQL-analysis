import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_33074_CredentialValidator_A08 {
    private static final String HASH_ALGORITHM = "SHA-256";

    public boolean validate(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            throw new InvalidParameterException("Null parameters are not allowed");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] hashedPasswordBytes = digest.digest(passwordBytes);

            return MessageDigest.isEqual(hashedPasswordBytes, hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No SHA-256 algorithm available", e);
        }
    }
}
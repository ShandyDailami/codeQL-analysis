import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_29312_CredentialValidator_A08 {

    private static final String ALGORITHM = "AES";

    public Optional<String> validate(String credentials, byte[] secret) {
        if (credentials == null || secret == null) {
            throw new InvalidParameterException("Credentials and secret must be provided");
        }

        byte[] decodedSecret = Base64.getDecoder().decode(secret);
        SecretKey key = new SecretKeySpec(decodedSecret, 0, decodedSecret.length, ALGORITHM);

        Optional<String> decryptedCredentials = decrypt(credentials, key);
        return decryptedCredentials.map(this::validateUserCredentials).orElse(Optional.empty());
    }

    private Optional<String> decrypt(String encryptedCredentials, SecretKey key) {
        try {
            byte[] decrypted = CryptoUtils.decrypt(encryptedCredentials, key);
            return Optional.of(new String(decrypted));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String validateUserCredentials(String decryptedCredentials) {
        // Implementation of user credential validation logic goes here
        // For example, check if user is active and if password is valid
        if (decryptedCredentials.isEmpty()) {
            throw new InvalidParameterException("Invalid credentials");
        }

        // If everything is valid, return the username
        return decryptedCredentials;
    }
}
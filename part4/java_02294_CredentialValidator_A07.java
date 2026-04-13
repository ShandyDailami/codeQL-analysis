import java.util.Base64;
import java.util.Optional;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_02294_CredentialValidator_A07 {

    private static final String AUTH_FAILURE_ERROR = "AuthFailure";
    private static final String SECRET_KEY = "superSecretKey";

    public Optional<SecretKey> validate(String encodedCredentials) {
        if (encodedCredentials == null || encodedCredentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials cannot be null or empty");
        }

        Optional<String> authFailureError = checkAuthFailure(encodedCredentials);

        if (authFailureError.isPresent()) {
            throw new AuthFailureException(authFailureError.get());
        }

        Optional<SecretKey> secretKey = validateSecretKey(encodedCredentials);

        if (secretKey.isEmpty()) {
            throw new InvalidCredentialsException("Invalid secret key");
        }

        return secretKey;
    }

    private Optional<String> checkAuthFailure(String encodedCredentials) {
        String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));

        if (decodedCredentials.contains(AUTH_FAILURE_ERROR)) {
            return Optional.of(AUTH_FAILURE_ERROR);
        }

        return Optional.empty();
    }

    private Optional<SecretKey> validateSecretKey(String encodedCredentials) {
        SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(encodedCredentials), 0, SECRET_KEY.getBytes());

        if (secretKey.getAlgorithm().equals(SECRET_KEY)) {
            return Optional.of(secretKey);
        }

        return Optional.empty();
    }
}
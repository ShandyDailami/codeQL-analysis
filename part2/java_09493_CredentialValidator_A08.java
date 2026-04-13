import java.util.Base64;
import java.util.Optional;

public class java_09493_CredentialValidator_A08 {

    private static final String VALID_PASSWORD = "password"; // This is a placeholder password. In a real scenario, this should be hashed and not stored as plaintext

    public Optional<String> validate(String userName, String password) {
        if (userName == null || password == null) {
            return Optional.empty();
        }

        if (!userName.equals(password)) {
            return Optional.of("Invalid username or password");
        }

        if (!passwordMatches(password)) {
            return Optional.of("Password does not match the expected pattern");
        }

        return Optional.empty();
    }

    private boolean passwordMatches(String password) {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes, 0, decodedBytes.length);

        return VALID_PASSWORD.equals(decodedPassword);
    }
}
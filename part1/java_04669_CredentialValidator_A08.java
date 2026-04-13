import java.util.Base64;
import java.util.Optional;

public class java_04669_CredentialValidator_A08 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public Optional<String> validate(String username, String password) {
        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            return Optional.empty();
        }

        return Optional.of(createToken(username));
    }

    private String createToken(String username) {
        String userCredentials = username + ":" + VALID_PASSWORD;
        String encodedCredentials = Base64.getEncoder().encodeToString(userCredentials.getBytes());

        return encodedCredentials;
    }
}
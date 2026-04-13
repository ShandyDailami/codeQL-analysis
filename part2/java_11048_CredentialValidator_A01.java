import java.util.Base64;
import java.util.Optional;

public class java_11048_CredentialValidator_A01 {
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";

    public Optional<String> validate(String user, String password) {
        // Check if user is not null and password is not null.
        if (user == null || password == null) {
            return Optional.empty();
        }

        // Decode the base64 encoded user and password.
        byte[] decodedUser = Base64.getDecoder().decode(user);
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Check if user and password match with the predefined credentials.
        if (new String(decodedUser).equals(USER_NAME) && new String(decodedPassword).equals(PASSWORD)) {
            return Optional.of("Access Granted");
        } else {
            return Optional.of("Access Denied");
        }
    }
}
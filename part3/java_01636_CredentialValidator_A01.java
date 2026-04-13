import java.util.Base64;
import java.util.Optional;

public class java_01636_CredentialValidator_A01 {
    private static final String USERNAME_AND_PASSWORD = "testUser:testPassword";

    public Optional<String> validateCredentials(String inputUsername, String inputPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(inputUsername);
        String decodedUsername = new String(decodedBytes);

        byte[] decodedPassword = Base64.getDecoder().decode(inputPassword);
        String decodedPasswordString = new String(decodedPassword);

        if (USERNAME_AND_PASSWORD.equals(decodedUsername + ":" + decodedPasswordString)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }
}
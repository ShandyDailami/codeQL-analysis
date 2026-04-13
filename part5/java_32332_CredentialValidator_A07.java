import java.util.Base64;
import java.util.Optional;

public class java_32332_CredentialValidator_A07 {

    public static Optional<String> validateCredentials(String user, String password) {
        // Storing the credentials in a base64 encoded string.
        // The credentials are stored in plaintext for simplicity and for the sake of illustration.
        String base64Credentials = Base64.getEncoder().encodeToString("user:password".getBytes());

        // The received credentials are decoded and compared.
        Optional<String> receivedCredentials = Optional.ofNullable(new String(Base64.getDecoder().decode(base64Credentials)));
        return receivedCredentials.filter(received -> received.equals(user + ":" + password))
                .map(unused -> "Credentials validated successfully");
    }

    public static void main(String[] args) {
        Optional<String> validationResult = validateCredentials("user", "password");
        validationResult.ifPresent(System.out::println);
    }
}
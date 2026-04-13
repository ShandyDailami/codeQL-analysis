import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class java_01807_CredentialValidator_A01 {
    private final String[] hardcodedCredentials;

    public java_01807_CredentialValidator_A01(String[] hardcodedCredentials) {
        this.hardcodedCredentials = hardcodedCredentials;
    }

    public Optional<String> validateCredential(String user, String password) {
        // Split username and password for comparison
        String[] userCredentials = user.split(":");

        // Check if credentials are hardcoded
        Optional<String> hardcodedPassword = Arrays.stream(hardcodedCredentials)
                .filter(credential -> credential.equals(userCredentials[0]))
                .findFirst();

        // If credentials match, return the password
        if (hardcodedPassword.isPresent()) {
            return Optional.of(new String(Base64.getDecoder().decode(hardcodedPassword.get())));
        }

        // If not, return an empty Optional
        return Optional.empty();
    }
}
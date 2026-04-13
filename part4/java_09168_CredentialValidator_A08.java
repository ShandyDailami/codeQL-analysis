import java.util.Base64;
import java.util.Optional;

public class java_09168_CredentialValidator_A08 {
    private String expectedPassword;

    public java_09168_CredentialValidator_A08(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public Optional<String> validate(String passwordAttempt) {
        byte[] decodedPassword = Base64.getDecoder().decode(passwordAttempt);
        String password = new String(decodedPassword);

        if (password.equals(expectedPassword)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid password");
        }
    }
}
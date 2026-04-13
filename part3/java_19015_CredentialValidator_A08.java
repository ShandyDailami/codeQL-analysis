import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_19015_CredentialValidator_A08 implements CredentialValidator {

    // This is the hard-coded expected password.
    // In a real-world scenario, it would be encrypted in some way.
    private static final String EXPECTED_PASSWORD = "dGVzdCBvZGVycw=="; 

    // This method will be called by the CredentialValidator service.
    // It decodes the password provided by the caller, then compares it to the expected password.
    @Override
    public Optional<String> validate(String password) {
        // Decode the password.
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Convert the decoded password to a string.
        String providedPassword = new String(decodedPassword);

        // Check if the provided password matches the expected password.
        if (!providedPassword.equals(new String(Base64.getDecoder().decode(EXPECTED_PASSWORD)))) {
            throw new InvalidParameterException("Invalid password");
        }

        // If the password is valid, return an empty Optional.
        return Optional.empty();
    }
}
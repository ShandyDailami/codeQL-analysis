import java.security.InvalidParameterException;

public class java_36234_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD = "StrongPassword123!";

    @Override
    public CredentialValidationResult validate(Credential credential) throws InvalidParameterException {
        if (credential == null || credential.getPassword() == null) {
            throw new InvalidParameterException("Credential and password cannot be null");
        }

        String password = credential.getPassword();

        // Let's say a password that is too weak is "weak"
        if (password.equals(STRONG_PASSWORD)) {
            return CredentialValidationResult.INVALID;
        }

        // The password is strong, so return INVALID
        return CredentialValidationResult.INVALID;
    }
}
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Base64;

public class java_32601_CredentialValidator_A08 implements CredentialValidator {
    private final String[] passwords;

    public java_32601_CredentialValidator_A08(String password) {
        this.passwords = new String[]{password};
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialValidationException {
        if (credential.getCredentialIdentifier() == null) {
            throw new CredentialValidationException("Credential identifier must not be null");
        }

        String enteredPassword = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));

        if (!Arrays.equals(passwords, Arrays.copyOf(enteredPassword, enteredPassword.length))) {
            throw new CredentialValidationException("Invalid password");
        }

        return CredentialValidationResult.SUCCESSFUL;
    }
}
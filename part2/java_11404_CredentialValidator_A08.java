import java.security.AuthenticationException;
import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_11404_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) throws GeneralSecurityException {
        String password = new String(credential.getCredentials(), 0, credential.getCredentials().length);
        // Simple password strength check: at least 8 characters, one upper-case letter, one lower-case letter, one digit, one special character
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$")) {
            return true;
        } else {
            throw new AuthenticationException("Invalid password.");
        }
    }
}
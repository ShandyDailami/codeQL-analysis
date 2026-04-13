import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_08487_CredentialValidator_A01 implements CredentialValidator {

    private static final String STRONG_PASSWORD = "StrongPassword";
    private static final String WEAK_PASSWORD = "WeakPassword";

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        String password = credential.getCredential();

        // This is a very basic password strength check. In a real-world application, you should use a more complex algorithm.
        if (password.equals(STRONG_PASSWORD)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}
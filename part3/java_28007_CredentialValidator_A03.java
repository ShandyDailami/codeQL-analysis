import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_28007_CredentialValidator_A03 implements javax.security.auth.login.CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // Check for nulls and empty strings
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return CredentialValidationResult.failed();
        }

        // If all checks pass, return successful
        return CredentialValidationResult.success();
    }
}
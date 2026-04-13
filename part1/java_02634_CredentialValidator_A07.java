import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_02634_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) throws LoginException {
        String password = credential.getCredentialIdentifier();
        
        if (password == null || password.trim().isEmpty()) {
            return CredentialValidationResult.failed("Invalid password");
        }

        // Assume we're always validating the password
        return CredentialValidationResult.success();
    }
}
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.PasswordChangeException;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.Subject;

public class java_35572_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        if ("user".equals(credential.getIdentifier()) && "password".equals(credential.getCredential())) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}
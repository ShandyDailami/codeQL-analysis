import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractValidation;

public class java_34499_CredentialValidator_A07 extends AbstractValidation {

    @Override
    public CredentialValidationResult validate(Subject subject, String username, String password) throws LoginException {
        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}
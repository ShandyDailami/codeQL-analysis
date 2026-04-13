import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_07971_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(jav.security.auth.Credential cred) {
        String username = cred.getIdentifier();
        String password = cred.getPassword();

        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}
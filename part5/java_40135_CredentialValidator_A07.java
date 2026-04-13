import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_40135_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential credential) throws LoginException {
        String password = credential.getPassword();
        // hardcoded passwords
        if ("password".equals(password)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}
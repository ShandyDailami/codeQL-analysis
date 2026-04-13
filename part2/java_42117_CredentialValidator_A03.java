import javax.security.auth.Credential;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validate.Validator;
import javax.security.auth.validate.CredentialValidatorResult;

public class java_42117_CredentialValidator_A03 implements Validator {

    @Override
    public CredentialValidatorResult validate(Credential credential) throws LoginException {
        String username = credential.getCaller();
        String password = credential.getPassword();

        // Stub authentication. Replace with your own logic.
        if ("user".equals(username) && "password".equals(password)) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}
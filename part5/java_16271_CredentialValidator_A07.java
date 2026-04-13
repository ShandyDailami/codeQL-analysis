import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.message.MessageException;
import java.security.GeneralSecurityException;

public class java_16271_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential cred) throws MessageException, LoginException, GeneralSecurityException {
        String password = cred.getPassword();
        if (password != null && password.length() >= 8) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}
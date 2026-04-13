import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.login.LoginException;
import java.util.Base64;

public class java_12022_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String username = new String(Base64.getDecoder().decode(credential.getIdentifier()));
        String password = new String(Base64.getDecoder().decode(credential.getPassword()));

        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}
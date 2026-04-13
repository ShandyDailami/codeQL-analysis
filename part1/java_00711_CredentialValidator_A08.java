import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.Subject;
import java.util.Base64;

public class java_00711_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public String validate(Subject subject, Credential credential) {
        String password = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));
        if (password.length() < 8) {
            throw new LoginException("Password must be at least 8 characters long");
        }
        return null;
    }
}
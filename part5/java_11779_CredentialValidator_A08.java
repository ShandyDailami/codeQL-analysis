import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_11779_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public PasswordAuthentication validate(Subject subject, Credential credential) {
        String password = credential.getCredentialIdentifier();
        if ("admin".equals(password)) {
            return new PasswordAuthentication(password, "Legacy Style Credential Validator", null);
        } else {
            return null;
        }
    }

    @Override
    public boolean requiresUsername() {
        return false;
    }
}
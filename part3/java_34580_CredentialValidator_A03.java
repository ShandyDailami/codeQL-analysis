import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.UnsupportedPasswordException;
import javax.security.auth.login.LoginException;

public class java_34580_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public PasswordState validate(Subject subject, Credential credential) {
        String user = credential.getIdentifier();
        String password = credential.getPassword();

        if ("admin".equals(user) && "password".equals(password)) {
            return PasswordState.VALID;
        } else {
            return PasswordState.invalid;
        }
    }
}
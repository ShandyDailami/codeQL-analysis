import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.UsernamePasswordCredential;

public class java_14250_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(Subject subject, String username, String password) throws LoginException {
        if ("admin".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password);
        }
        throw new LoginException("Invalid username or password");
    }
}
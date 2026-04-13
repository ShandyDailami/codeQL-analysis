import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_22074_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        if ("user".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}
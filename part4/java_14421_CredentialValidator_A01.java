import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;

public class java_14421_CredentialValidator_A01 {

    public boolean validate(Credential credential) {
        // simulate a login attempt with a username and password
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // assume username and password are correct
        if ("user".equals(username) && "password".equals(password)) {
            return true;
        }

        return false;
    }
}
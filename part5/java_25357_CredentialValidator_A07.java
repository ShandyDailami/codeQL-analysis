import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordBroker;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_25357_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential arg0) throws LoginException {
        if (arg0.getIdentifier().equals(USERNAME) && arg0.getCredential().equals(PASSWORD)) {
            return null; // if everything is correct, return null
        } else {
            throw new LoginException("Invalid username or password"); // otherwise throw a login exception
        }
    }

}
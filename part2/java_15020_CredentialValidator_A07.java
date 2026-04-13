import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordBroker;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;

public class java_15020_CredentialValidator_A07 implements CredentialValidator {

    private PasswordBroker broker;

    public java_15020_CredentialValidator_A07(PasswordBroker broker) {
        this.broker = broker;
    }

    @Override
    public Credential validate(Credential credential) throws LoginException {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        String password = usernamePasswordCredential.getPassword();

        // Check the password strength
        if (password.length() < 8 || !password.matches(".*[0-9].*") || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[^a-zA-Z0-9].*")) {
            throw new LoginException("Password is not strong enough");
        }

        // Check the password is not the same as the user's username
        if (password.equals(usernamePasswordCredential.getUsername())) {
            throw new LoginException("Password cannot be the same as username");
        }

        // Check the password is not the same as the user's email
        if (password.equals(usernamePasswordCredential.getSystemName())) {
            throw new LoginException("Password cannot be the same as email");
        }

        return usernamePasswordCredential;
    }

    @Override
    public boolean validate(Credential credential, boolean authenticateOnly) throws LoginException {
        return authenticateOnly;
    }
}
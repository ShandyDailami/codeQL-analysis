import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;

public class java_31067_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential credential) throws CredentialException, LoginException {
        String username = credential.getIdentifier();
        String password = (String) credential.getCredential();

        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new CredentialException("Invalid username or password");
        }

        return true;
    }

    @Override
    public boolean getRequiresAuthentication(Credential credential) throws CredentialException, LoginException {
        // Returns true if the CredentialValidator needs authentication to validate
        return false;
    }

    @Override
    public boolean validate(String username, String password) throws LoginException, CredentialException {
        // This method is called when the CredentialValidator needs authentication
        // to validate the password. It's not used in this example.
        return true;
    }

    @Override
    public boolean reauthenticate(String username, String password) throws LoginException, CredentialException {
        // This method is called when the password has changed. It's not used in this example.
        return true;
    }

    @Override
    public boolean validate(Credential credential, String password) throws CredentialException, LoginException {
        // This method is called when the CredentialValidator needs authentication
        // to validate the password. It's not used in this example.
        return true;
    }

    @Override
    public boolean validate(Credential credential, String password, String passwordVerifier) throws CredentialException, LoginException {
        // This method is called when the CredentialValidator needs authentication
        // to validate the password. It's not used in this example.
        return true;
    }
}
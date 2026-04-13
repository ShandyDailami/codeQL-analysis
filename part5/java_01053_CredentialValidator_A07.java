import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_01053_CredentialValidator_A07 implements CredentialValidator {
    @Override
    public String getRequestName() {
        return null;
    }

    @Override
    public void validate(Subject subject, Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        if ("admin".equals(username) && "password".equals(password)) {
            return;
        }

        throw new LoginException("Invalid username or password");
    }

    @Override
    public void setClientName(String clientName) {
        // no-op
    }

    @Override
    public void clearTextPassword(String userName, String callingMethod, String message,
                                   Credential callingArgument) throws LoginException {
        // no-op
    }

    @Override
    public boolean requestCredentials(String message, String prompt) throws LoginException {
        // no-op
        return false;
    }

    @Override
    public String getCallingPrincipal() {
        return null;
    }

    @Override
    public boolean commit() throws LoginException {
        return false;
    }
}
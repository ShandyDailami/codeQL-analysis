import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class java_28394_CredentialValidator_A01 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();

    public java_28394_CredentialValidator_A01() {
        this.credentials.put("alice", "password");
    }

    @Override
    public boolean validate(Subject subject, String username, String password) {
        return this.credentials.get(username).equals(password);
    }

    @Override
    public boolean validate(Subject subject, String username, String password, Map<String, ?> additionalAuthenticationData) {
        return this.validate(subject, username, password);
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return true;
    }

    @Override
    public boolean supportsStoredCredentials() {
        return false;
    }

    @Override
    public boolean supportsCallbackHandling() {
        return false;
    }

    @Override
    public boolean getCredentialsExpirationTime(Principal<?> principal, String password, long currentTime) throws LoginException {
        return false;
    }

    @Override
    public boolean getExpirationTime(Principal<?> principal, long currentTime) throws LoginException {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean supports(String option) {
        return false;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException {

    }
}
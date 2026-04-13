import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_17188_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    private Map<String, String> creds = new HashMap<>();

    public java_17188_CredentialValidator_A03() {
        creds.put("user1", "password1");
        creds.put("user2", "password2");
    }

    @Override
    public Subject validate(Subject subject) throws LoginException {
        return subject;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws LoginException {
        String providedCredentials = credentials.toString();
        String expectedCredentials = creds.get(subject.getPrincipal());

        if (providedCredentials.equals(expectedCredentials)) {
            return true;
        } else {
            throw new LoginException("Invalid credentials");
        }
    }

    @Override
    public boolean getRequirement(String requirement) throws LoginException {
        return false;
    }

    @Override
    public boolean supports(String arg0) {
        return false;
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getUniqueIdentifier() {
        return null;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return null;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {

    }

    @Override
    public void initialize(String arg0, Map<String, String> arg1) throws LoginException, IOException, UnsupportedCallbackException {

    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getOneWayCredentials() {
        return null;
    }

    @Override
    public Object getRequestProperties() {
        return null;
    }

    @Override
    public void setRequestProperties(Map<String, String> arg0) {

    }
}
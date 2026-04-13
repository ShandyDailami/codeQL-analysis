import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_22979_CredentialValidator_A07 implements CallbackHandler {
    private Map<String, String> credentials = new HashMap<>();

    public java_22979_CredentialValidator_A07() {
        credentials.put("username", "admin");
        credentials.put("password", "password");
    }

    @Override
    public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
        String property = callback.getRequest().getRequestedLDAPEntry().getClass().getName();

        if (property.equals("javax.security.auth.password.PasswordContext")) {
            callback.setCallbackType("password");
            callback.setUnsolicited(true);
            callback.setRequestedLDAPEntry("");
            callback.setRequestedInfo("");
            callback.setRequestedPassword("");
        } else {
            callback.setCallbackType("username");
            callback.setUnsolicited(true);
            callback.setRequestedLDAPEntry("");
            callback.setRequestedInfo("");
        }

        String credential = credentials.get(callback.getRequest().getRequestedLDAPEntry());

        if (credential == null) {
            throw new CredentialException("Unable to get the credential for: " + callback.getRequest().getRequestedLDAPEntry());
        }

        callback.setRequestedPassword(credential);
    }
}

public class CustomCredentialValidator implements javax.security.auth.credential.CredentialValidator {
    @Override
    public Subject validate(Subject subject) throws CredentialException {
        return subject;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws CredentialException {
        String password = (String) credentials;
        return password.equals("password");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CustomCallbackHandler();
    }
}
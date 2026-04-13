import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class java_40851_CredentialValidator_A03 implements Serializable, CredentialValidator {
    private static final long serialVersionUID = 1L;

    private Map<String, String> credentials = new HashMap<>();

    public java_40851_CredentialValidator_A03() {
        credentials.put("username", "admin");
        credentials.put("password", "password");
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        CredentialValidationResult result = new CredentialValidationResult(null);

        try {
            String user = credential.getID();
            String password = credential.getCredentialIdentifier();

            if (user.equals(credentials.get("username")) && password.equals(credentials.get("password"))) {
                result = new CredentialValidationResult("Success", null);
            } else {
                result = new CredentialValidationResult("Failure", "Invalid Credentials");
            }
        } catch (Exception ex) {
            result = new CredentialValidationResult("Failure", ex.getMessage());
        }

        return result;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new MyCallbackHandler();
    }
}

class MyCallbackHandler implements CallbackHandler {
    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        return new MyCredentialValidator().validate(subject, credential);
    }

    @Override
    public void cleanup(Subject subject, Credential credential) throws IOException, UnsupportedCallbackException {
    }
}
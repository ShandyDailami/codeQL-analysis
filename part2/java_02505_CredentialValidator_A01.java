import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_02505_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_02505_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public Subject validate(Subject subject, Credential credential) throws LoginException, IOException, UnsupportedCallbackException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return subject;
        }

        throw new LoginException("Invalid credentials");
    }

    @Override
    public boolean supports(Credential c) {
        return c instanceof CustomCredential;
    }

    @Override
    public boolean getSupports(Class<?> clazz) {
        return true;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CustomCallbackHandler();
    }

    private static class CustomCallbackHandler implements CallbackHandler {
        @Override
        public CredentialValidationResult validate(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof CustomCredential) {
                    return new CredentialValidationResult("Success");
                }
            }
            return new CredentialValidationResult("Failure");
        }
    }
}
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_16578_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> hardCodedPasswords;

    public java_16578_CredentialValidator_A01() {
        hardCodedPasswords = new HashMap<>();
        hardCodedPasswords.put("user1", "password1");
        hardCodedPasswords.put("user2", "password2");
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String username = credential.getIdentifier();
        String password = credential.getCredentialIdentifier();

        if (hardCodedPasswords.containsKey(username) &&
                hardCodedPasswords.get(username).equals(password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public CredentialValidationResult getValidationResult(Subject subject, Credential credential, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
                return validate(subject, credential);
            }

            @Override
            public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
                // Not used in this example
            }
        };
    }
}
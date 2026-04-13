import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_05407_CredentialValidator_A03 implements CredentialValidator {

    private Set<String> userRoles;
    private CallbackHandler callbackHandler;

    public java_05407_CredentialValidator_A03() {
        userRoles = new HashSet<>(Arrays.asList("ADMIN", "USER"));
        callbackHandler = new CallbackHandler() {
            @Override
            public CredentialValidationResult validate(Subject subject, Credential credential) {
                if (credential instanceof UsernamePasswordCredential) {
                    UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
                    String username = usernamePasswordCredential.getIdentifier();
                    if (userRoles.contains(username)) {
                        return new CredentialValidationResult("Success");
                    } else {
                        return new CredentialValidationResult("Unknown User");
                    }
                } else {
                    return new CredentialValidationResult("Wrong Credential Type");
                }
            }

            @Override
            public CredentialValidationResult generateChallenge(Subject subject, String challenge) throws LoginException, IOException, UnsupportedCallbackException {
                return null;
            }
        };
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) throws LoginException, IOException, UnsupportedCallbackException {
        return callbackHandler.validate(subject, credential);
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Credential credential) throws LoginException, UnsupportedCallbackException {
        this.callbackHandler = callbackHandler;
        this.credential = credential;
    }

    private Credential credential;

    @Override
    public boolean commit() throws LoginException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public void abort(Subject subject, Credential credential) throws LoginException, UnsupportedCallbackException {
        // Do nothing
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
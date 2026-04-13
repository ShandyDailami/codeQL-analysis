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

public class java_02773_CredentialValidator_A01 implements CredentialValidator {
    private static final Set<String> USERS = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> PASSWORDS = new HashSet<>(Arrays.asList("password1", "password2", "password3"));

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String user = credential.getCredentialIdentifier();
        String password = new String(credential.getCredential());

        if (USERS.contains(user) && PASSWORDS.contains(password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public CredentialValidationResult handle(Callback[] callbacks) throws IOException, LoginException, UnsupportedCallbackException {
                return null;
            }
        };
    }
}
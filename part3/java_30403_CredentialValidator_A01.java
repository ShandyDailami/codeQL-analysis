import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_30403_CredentialValidator_A01 implements CredentialValidator {

    private static final Set<String> USER_ROLES = new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

    @Override
    public Credential validate(Subject subject, Credential credential) {
        String username = credential.getCredentialIdentifier();
        String password = (String) credential.getCredentials();

        // This is a simple example. In a real scenario, you should use SSL and other security measures.
        if ("admin".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            return null;
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public CredentialValidationResult validate(Callback[] callbacks) throws IOException, LoginException {
                return new CredentialValidationResult(null);
            }
        };
    }
}
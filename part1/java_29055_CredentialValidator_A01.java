import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.credential.UsernamePasswordCredential;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_29055_CredentialValidator_A01 implements CredentialValidator {

    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private Set<String> allowedPasswords = new HashSet<>(Arrays.asList("password1", "password2", "password3"));

    @Override
    public boolean validate(Subject subject, UsernamePasswordCredential credential) throws CredentialException {
        String user = credential.getUsername();
        String password = credential.getPassword();
        return allowedUsers.contains(user) && allowedPasswords.contains(password);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public void handle(Callback callback) throws UnsupportedCallbackException, CredentialException {
                // No additional callbacks are required here
            }
        };
    }
}
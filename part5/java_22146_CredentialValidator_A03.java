import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.security.auth.Subject;
import java.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_22146_CredentialValidator_A03 implements CredentialValidator {

    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "admin"));

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler)
            throws AccessControlException {
        String user = credentials.toString();
        return allowedUsers.contains(user);
    }
}
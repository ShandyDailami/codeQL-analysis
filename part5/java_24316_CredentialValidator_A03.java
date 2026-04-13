import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_24316_CredentialValidator_A03 implements CallbackHandler {

    private Set<String> allowedUsers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("user1", "user2", "user3")));
    private Set<String> allowedRoles = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("admin", "user")));

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean validate(Subject subject, Callback[] callbacks) throws IOException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];
        String user = callback.getIdentifier();
        String password = new String(callback.getPassword());

        if (allowedUsers.contains(user) && allowedRoles.contains(password)) {
            callback.setError(0);
            return true;
        } else {
            callback.setError(1);
            return false;
        }
    }
}
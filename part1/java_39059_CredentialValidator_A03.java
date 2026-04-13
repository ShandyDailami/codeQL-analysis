import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_39059_CredentialValidator_A03 implements CallbackHandler {

    private Set<String> validUsers;

    public java_39059_CredentialValidator_A03() {
        validUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    }

    @Override
    public AuthenticationStatus callbackHandler(Subject subject, Callback[] callbacks) throws IOException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        String username = callback.getIdentifier();
        char[] password = callback.getPassword();

        if (validUsers.contains(username)) {
            return AuthenticationStatus.SUCCESS;
        } else {
            return AuthenticationStatus.FAILURE;
        }
    }
}
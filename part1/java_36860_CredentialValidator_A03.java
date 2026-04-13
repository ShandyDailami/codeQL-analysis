import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.AccessControlContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_36860_CredentialValidator_A03 implements CallbackHandler {

    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public UsernamePasswordCallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean validate(Subject subject, String callerQualifiedName,
                           Object credential) throws LoginException {
        String username = callerQualifiedName;
        String password = credential.toString();

        return allowedUsers.contains(username) && password.equals("password");
    }
}
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_05169_CredentialValidator_A07 implements CallbackHandler {

    private final Set<String> supportedActions = new HashSet<>(Arrays.asList("CREATE", "READ", "UPDATE", "DELETE"));

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handle(Callback callback) throws IOException, LoginException {
        if (callback instanceof UsernamePasswordCallback) {
            UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;

            // Check if the user is trying to perform an action that is not supported
            if (!supportedActions.contains(callbackObj.getAction())) {
                throw new LoginException("Action not supported by CredentialValidator");
            }

            // Validate the username and password
            if ("CREATE".equals(callbackObj.getAction()) && callbackObj.getPassword() == null) {
                throw new LoginException("Invalid password");
            }

            if ("UPDATE".equals(callbackObj.getAction()) && callbackObj.getPassword() == null) {
                throw new LoginException("Invalid password");
            }

            // Check if the user has the required permissions to perform the action
            Subject subject = new Subject.Builder().build();
            // Add your permissions here
            if ("CREATE".equals(callbackObj.getAction()) && !subject.getPrincipal().getName().equals("admin")) {
                throw new LoginException("Insufficient permissions");
            }

            if ("UPDATE".equals(callbackObj.getAction()) && !subject.getPrincipal().getName().equals("admin")) {
                throw new LoginException("Insufficient permissions");
            }

            if ("DELETE".equals(callbackObj.getAction()) && !subject.getPrincipal().getName().equals("admin")) {
                throw new LoginException("Insufficient permissions");
            }

            return true; // Authentication successful
        }
        return false; // Unsupported callback
    }
}
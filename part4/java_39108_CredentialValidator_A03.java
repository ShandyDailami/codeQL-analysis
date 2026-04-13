import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.role.Role;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_39108_CredentialValidator_A03 implements javax.security.auth.login.CredentialValidator {
    private static final Set<Role> USER_ROLES = new HashSet<>(Arrays.asList(new Role[]{new Role("USER")}));

    public Set<Role> getUserRoles(Subject subject) {
        return USER_ROLES;
    }

    public boolean validate(Subject subject, Object credentials) {
        String input = (String) credentials;
        return input != null && !input.isEmpty();
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // Not implemented in this example
    }

    public void handle(Callback callback) throws UnsupportedCallbackException {
        // Not implemented in this example
    }

    public boolean getPasswordChangeAllowed() {
        return false;
    }
}
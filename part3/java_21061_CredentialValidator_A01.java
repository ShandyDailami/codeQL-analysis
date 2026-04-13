import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_21061_CredentialValidator_A01 implements CallbackHandler {

    // A collection of roles that this validator can validate.
    private final Set<String> validRoles;

    public java_21061_CredentialValidator_A01() {
        this.validRoles = new HashSet<>(Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_DBA"));
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean validate(Subject subject, Callback[] callbacks) throws IOException, LoginException {
        // We only have one callback here: UsernamePasswordCallback.
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        // Validate the username.
        if (!validRoles.contains(callback.getUsername())) {
            throw new LoginException("Invalid username: " + callback.getUsername());
        }

        // Validate the password.
        // Here we're just doing a simple string comparison. In a real application,
        // you'd have to hash and salt the passwords.
        if (!"password".equals(callback.getPassword())) {
            throw new LoginException("Invalid password");
        }

        // If everything is valid, return true.
        return true;
    }
}
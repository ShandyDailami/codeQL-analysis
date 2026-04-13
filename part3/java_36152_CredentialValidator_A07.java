import javax.naming.AuthenticationException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordCallbackHandler;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_36152_CredentialValidator_A07 implements CallbackHandler {
    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("admin", "test"));

    @Override
    public Callback[] getCallbacks() throws IOException, LoginException, UnsupportedCallbackException {
        return new UsernamePasswordCallbackHandler();
    }

    @Override
    public void validate(Callback[] callbacks) throws IOException, LoginException {
        UsernamePasswordCallbackHandler handler = (UsernamePasswordCallbackHandler) callbacks[0];
        String presentedPassword = handler.getPassword();
        String presentedUsername = handler.getUsername();

        if (!allowedUsers.contains(presentedUsername) || !checkPassword(presentedPassword)) {
            throw new AuthenticationException("Invalid Credentials");
        }
    }

    private boolean checkPassword(String password) {
        // Assuming password checking here is a bit more complex and not a simple equality check
        // For simplicity, just checking if the password is "password"
        return password.equals("password");
    }
}
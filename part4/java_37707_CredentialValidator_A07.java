import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.login.LoginContext;

public class java_37707_CredentialValidator_A07 implements CallbackHandler {

    private Map<String, String> credentials;

    public java_37707_CredentialValidator_A07() {
        credentials = new HashMap<>();
    }

    public void setCredentials(String user, String password) {
        credentials.put("username", user);
        credentials.put("password", password);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException, AuthenticationException {
        for (Callback callback : callbacks) {
            // Verify user and password
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequestedPassword("");
                cb.setRequestedPassword("");
            }
            if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                // Verify the credentials and if successful, set the password
                if (credentials.get("username").equals(cb.getID())) {
                    String pass = credentials.get("password");
                    cb.setRequestedPassword(pass);
                } else {
                    throw new AuthenticationException("Invalid username or password");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator cv = new CredentialValidator();
        cv.setCredentials("admin", "password");

        // Create subject
        Subject subject = new Subject("myRealm");

        // Create login context
        LoginContext lc = new LoginContext("myRealm", subject, cv);

        // Perform login
        lc.login();

        // Check if login was successful
        if (lc.getSubject().getPrincipal() == null) {
            System.out.println("Failed to login");
        } else {
            System.out.println("Successfully logged in as " + lc.getSubject().getPrincipal());
        }
    }
}
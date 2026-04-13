import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class java_13336_CredentialValidator_A08 implements CallbackHandler {

    private static final String EXPECTED_PASSWORD = "expectedPassword";
    private static final String PASSWORD_STORE_CLASS = "com.sun.security.auth.password.PasswordStore";

    private final Map<String, String> passwords = new HashMap<>();

    public java_13336_CredentialValidator_A08() {
        passwords.put("user1", "password1");
        passwords.put("user2", "password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // No implementation needed here
    }

    public AccessControlContext login(final String username, final String password, final Guard guard, final AccessControlListener listener) {
        if (!passwords.containsKey(username)) {
            throw new IllegalArgumentException("User not found.");
        }

        String expectedPassword = passwords.get(username);
        if (!expectedPassword.equals(password)) {
            throw new IllegalArgumentException("Invalid password.");
        }

        return new AccessControlContext(Collections.emptySet()) {
            @Override
            public boolean success() {
                return true;
            }

            @Override
            public boolean failure() {
                return false;
            }

            @Override
            public boolean getRequirement() {
                return false;
            }
        };
    }
}
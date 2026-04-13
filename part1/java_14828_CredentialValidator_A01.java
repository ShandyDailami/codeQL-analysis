import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_14828_CredentialValidator_A01 implements CredentialValidator {

    private static final Set<String> VALID_USERNAMES = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> VALID_PASSWORDS = new HashSet<>(Arrays.asList("pass1", "pass2", "pass3"));

    @Override
    public Credential validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        return new Credential() {
            @Override
            public String getCallerPrincipal() {
                return getUsername();
            }

            @Override
            public String getPassword() {
                return getPassword();
            }

            @Override
            public boolean getAuthorizationAttributes(String s, String s1, Callback[] callbacks) throws UnsupportedCallbackException {
                return false;
            }

            private String getUsername() {
                String username;
                Callback[] callbacks = new Callback[]{new UsernameCallback()};
                callbackHandler.getNextCallback(callbacks);
                if (callbacks[0] instanceof UsernameCallback) {
                    username = ((UsernameCallback) callbacks[0]).getUsername();
                } else {
                    throw new UnsupportedCallbackException();
                }
                return username;
            }

            private String getPassword() {
                String password;
                Callback[] callbacks = new Callback[]{new PasswordCallback()};
                callbackHandler.getNextCallback(callbacks);
                if (callbacks[0] instanceof PasswordCallback) {
                    password = ((PasswordCallback) callbacks[0]).getPassword();
                } else {
                    throw new UnsupportedCallbackException();
                }
                return password;
            }

            @Override
            public boolean validate(Credential credential) throws PasswordChangeException {
                return isValidCredentials(credential.getCallerPrincipal(), credential.getPassword());
            }

            private boolean isValidCredentials(String username, String password) {
                return VALID_USERNAMES.contains(username) && VALID_PASSWORDS.contains(password);
            }
        };
    }

    private static class UsernameCallback extends UnsupportedCallbackException implements Callback {
        private String username;

        @Override
        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getUsername() {
            return username;
        }
    }

    private static class PasswordCallback extends UnsupportedCallbackException implements Callback {
        private String password;

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }
}
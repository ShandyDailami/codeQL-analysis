import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_01923_CredentialValidator_A07 implements CallbackHandler {

    private String[] expectedUsernames = {"user1", "user2", "user3"};
    private String[] expectedPasswords = {"password1", "password2", "password3"};

    @Override
    public CallbackHandler getInstance() {
        return this;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException, LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                String username = cb.getUsername();
                if (!isUsernameValid(username)) {
                    throw new LoginException("Invalid username");
                }
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                String password = new String(cb.getPassword());
                if (!isPasswordValid(password)) {
                    throw new LoginException("Invalid password");
                }
            }
        }
    }

    private boolean isUsernameValid(String username) {
        for (String validUsername : expectedUsernames) {
            if (validUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordValid(String password) {
        for (String validPassword : expectedPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static class UsernameCallback implements Callback {
        private String username;

        public java_01923_CredentialValidator_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class PasswordCallback implements Callback {
        private char[] password;

        public java_01923_CredentialValidator_A07(char[] password) {
            this.password = password;
        }

        public char[] getPassword() {
            return password;
        }

        public void setPassword(char[] password) {
            this.password = password;
        }
    }
}
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.username.UsernamePasswordAuthenticationToken;
import javax.security.auth.password.PasswordAuthenticationToken;
import javax.security.auth.message.AuthException;

public class java_01502_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public CallbackHandler getInstance(Subject subject, String authSchemeName, Map<String, ?> authenticationParameters) {
        return new CustomCredentialValidator();
    }

    @Override
    public Callback[] getCallbacks(String challenge) throws AuthException {
        return new Callback[]{new UsernamePasswordCallback()};
    }

    private class UsernamePasswordCallback implements Callback, UsernamePasswordAuthenticationToken {

        private String username;
        private char[] password;

        @Override
        public void setPassword(char[] password) {
            this.password = password;
        }

        @Override
        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getPassword() {
            return new String(this.password);
        }

        @Override
        public String getUsername() {
            return this.username;
        }

        @Override
        public void validate() throws AuthException {
            if (this.username == null || this.username.length() == 0) {
                throw new AuthException("Username cannot be null or empty");
            }

            if (this.password == null || this.password.length == 0) {
                throw new AuthException("Password cannot be null or empty");
            }

            // Here, you can add security sensitive operations related to injection attacks
            // For instance, you can check for injection attempts in the password
            // If injection attempts are detected, you can throw an AuthException
            // For example:

            for (char c : this.password) {
                if (c == ';') {
                    throw new AuthException("Injection attempt detected in password");
                }
            }
        }
    }
}
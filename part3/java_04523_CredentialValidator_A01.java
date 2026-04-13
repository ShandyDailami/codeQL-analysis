import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_04523_CredentialValidator_A01 implements CallbackHandler {

    private String expectedUsername;
    private String expectedPassword;

    public java_04523_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public Credential handle(Callback callback) throws CredentialException, UnsupportedCallbackException {
        String username = (String) callback.getRequest().getParameter("username");
        String password = (String) callback.getRequest().getParameter("password");

        if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
            throw new CredentialException("Invalid credentials");
        }

        return new CustomCredential(username, password);
    }

    private class CustomCredential implements Credential {

        private String username;
        private String password;

        public java_04523_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getCredential() {
            return password;
        }

        @Override
        public String getName() {
            return username;
        }
    }
}
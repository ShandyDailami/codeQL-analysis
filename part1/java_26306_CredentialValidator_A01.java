import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

import com.sun.security.auth.callback.PasswordCallbackHandler;

public class java_26306_CredentialValidator_A01 implements CallbackHandler {

    private String expectedUsername;
    private char[] expectedPassword;

    public java_26306_CredentialValidator_A01(String expectedUsername, char[] expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public UsernamePasswordAuthenticationToken getAuthenticationToken(String username, String password) throws LoginException, UnsupportedCallbackException {
        if (username == null || password == null || !username.equals(expectedUsername) || !Arrays.equals(password, expectedPassword)) {
            throw new LoginException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(username, password, null);
    }

    @Override
    public CallbackHandler getCallbackHandler() throws UnsupportedCallbackException {
        return new PasswordCallbackHandler(expectedPassword, false);
    }
}
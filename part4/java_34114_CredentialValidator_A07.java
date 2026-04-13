import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.authloop.AuthLoopException;
import javax.security.auth.login.LoginException;

public class java_34114_CredentialValidator_A07 implements CallbackHandler {

    private static final String[][] credentialList = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
        {"user4", "pass4"}
    };

    @Override
    public UsernamePasswordAuthenticationToken getPasswordAuthenticationToken(String username, String password, String callerQualifiedName, String role) throws LoginException, AuthLoopException, UnsupportedCallbackException {
        for (String[] credential : credentialList) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return new UsernamePasswordAuthenticationToken(username, password, null);
            }
        }
        throw new LoginException("Authentication failed");
    }
}
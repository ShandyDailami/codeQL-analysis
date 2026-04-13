import javax.security.auth.callback.*;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialException;

public class java_11888_CredentialValidator_A07 implements CallbackHandler {

    private static final String[][] VALID_CREDENTIALS = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    @Override
    public AuthenticationStatus validate(CallbackHandler callbackHandler,
                                       Map<String, String> map) throws CredentialException, LoginException {
        // use callbackHandler to get username and password
        UsernamePasswordCallback handler = new UsernamePasswordCallback(map);
        callbackHandler.getCallback(handler);

        // validate credentials
        String username = handler.getUsername();
        String password = handler.getPassword();

        boolean valid = false;
        for (String[] credential : VALID_CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new CredentialException("Invalid username or password");
        }

        return AuthenticationStatus.SUCCESS;
    }
}
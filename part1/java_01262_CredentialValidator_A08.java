import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth. UsernamePasswordAuthenticationToken;
import javax.security.auth.message.AuthException;

import javax.security.auth.Subject;
import java.security.AuthProvider;
import java.security.Principal;

public class java_01262_CredentialValidator_A08 implements AuthProvider {
    private final String user = "user";
    private final String password = "password";

    public Principal validate(Subject subject, String username, String password) {
        if (this.user.equals(username) && this.password.equals(password)) {
            return new Principal(username);
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    // Other methods...
}

public class CustomCallbackHandler implements CallbackHandler {
    public UsernamePasswordAuthenticationToken getAuthenticationToken(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    // Other methods...
}

public class CustomSubject extends Subject {
    public Subject setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    // Other methods...
}
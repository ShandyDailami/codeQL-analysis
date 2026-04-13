import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.passwordless.PasswordlessAuthenticationMechanism;
import javax.security.auth.passwordless.PasswordlessAuthenticationMechanism$Result;
import javax.security.auth.passwordless.State;
import java.security.GeneralSecurityException;

public class java_28072_CredentialValidator_A01 implements CallbackHandler {
    private final State state;
    private final Properties props;

    public java_28072_CredentialValidator_A01(State state, Properties props) {
        this.state = state;
        this.props = props;
    }

    @Override
    public void handle(Callback[] callbacks)
            throws UnsupportedCallbackException, GeneralSecurityException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) callbacks[0].getToken();

        if (token == null) {
            throw new IllegalStateException("No token present");
        }

        if (token.getCredentials() == null) {
            throw new IllegalStateException("No credentials present");
        }

        if (token.getPrincipal() == null) {
            throw new IllegalStateException("No user present");
        }

        PasswordlessAuthenticationMechanism mechanism = PasswordlessAuthenticationMechanism.getPasswordlessMechanism(state);
        PasswordlessAuthenticationMechanism$Result result = mechanism.authenticate(state, props);

        if (!result.isAuthenticated()) {
            throw new GeneralSecurityException("Authentication failed");
        }

        token.setAuthenticated(true);
    }
}
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_17752_CredentialValidator_A03 implements CallbackHandler {

    private Properties props;

    public java_17752_CredentialValidator_A03() {
        props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/security.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) callback;
            if (token.getCredentials() == null) {
                throw new UnsupportedCallbackException("Authentication Credential is null");
            }
            if (token.getCredentials().length == 0) {
                throw new UnsupportedCallbackException("Authentication Credential is empty");
            }
            if (!token.getCredentials().equals(props.getProperty("password"))) {
                throw new UnsupportedCallbackException("Authentication Credentials do not match");
            }
        }
    }
}
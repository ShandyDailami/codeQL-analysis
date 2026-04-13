import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.AuthenticationException;
import java.util.Properties;

public class java_33733_CredentialValidator_A07 implements CallbackHandler {

    private Properties props;

    public java_33733_CredentialValidator_A07() {
        InputStream in = this.getClass().getResourceAsStream("/credentials.properties");
        props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public java.security.Authentication getAuthentication() throws AccessDeniedException {
        return null;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        throw new UnsupportedCallbackException(null, "No passwords are required for authentication");
    }

    public boolean validate(String username, String password) throws AuthenticationException {
        return password.equals(props.getProperty(username));
    }
}
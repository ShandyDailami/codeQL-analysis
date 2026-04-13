import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Guard;
import java.security.GuardSelector;
import java.security.PrivilegedAction;
import java.security.credential.Credential;
import java.security.credential.CredentialAccessException;
import java.security.guard.GuardSatisfaction;
import java.util.Properties;

public class java_27018_CredentialValidator_A07 implements CallbackHandler {
    private final Properties props;

    public java_27018_CredentialValidator_A07(Properties props) {
        this.props = props;
    }

    @Override
    public Credential[] getCredentials(String arg0, String arg1, String arg2,
                                       String arg3, Callback[] callbacks)
            throws IOException, UnsupportedCallbackException {
        if (props.getProperty("credential.username").equals(arg0)
                && props.getProperty("credential.password").equals(arg1)) {
            Credential credential = new Credential() {
                @Override
                public String getName() {
                    return arg0;
                }

                @Override
                public String getTransitionPassword() {
                    return arg1;
                }

                @Override
                public String getId() {
                    return arg0;
                }

                @Override
                public String getPassword() {
                    return arg1;
                }

                @Override
                public void refreshPassword() throws CredentialAccessException {
                    // no-op
                }
            };
            return new Credential[]{credential};
        } else {
            throw new CredentialAccessException("Invalid credentials");
        }
    }
}
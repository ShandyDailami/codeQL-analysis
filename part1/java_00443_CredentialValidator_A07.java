import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_00443_CredentialValidator_A07 implements CredentialValidator {

    private Properties props;

    public java_00443_CredentialValidator_A07(Properties props) {
        this.props = props;
    }

    @Override
    public UsernamePasswordAuthenticationToken getAuthenticationToken(Subject subject, String username, Object password, String callerPrefix) throws LoginException {
        if (username != null && username.equals(props.getProperty("username")) && password != null && password.equals(props.getProperty("password"))) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new LoginException("Authentication failed");
        }
    }

    @Override
    public boolean validate(Subject subject, String callerPrefix) throws IOException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // This method is not used in this example
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler, String callbackAction, Properties properties) throws IOException, UnsupportedCallbackException {
        // This method is not used in this example
        return null;
    }

}
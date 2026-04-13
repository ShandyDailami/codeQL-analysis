import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class java_00063_CredentialValidator_A07 implements CredentialValidator {

    private Properties props;

    public java_00063_CredentialValidator_A07() {
        try {
            InputStream in = getClass().getResourceAsStream("/config.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String username = credential.getID();
        String password = credential.getCredentialIdentifier();

        if (username.equals(props.getProperty("username")) && password.equals(props.getProperty("password"))) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", "A07_AuthFailure");
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public CredentialValidationResult getValidationResult(Subject subject, Credential credential, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
                return validate(subject, credential);
            }

            @Override
            public void handle(Callback callback) throws UnsupportedCallbackException {
                // Not used in this example
            }
        };
    }
}
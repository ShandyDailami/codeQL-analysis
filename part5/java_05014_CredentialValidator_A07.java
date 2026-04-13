import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.login.LoginException;
import javax.security.auth.username.UsernamePasswordAuthenticationToken;

public class java_05014_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private Properties props;

    public java_05014_CredentialValidator_A07() {
        this.props = new Properties();
    }

    @Override
    public Subject validate(Subject subject) throws LoginException {
        if (props.getProperty("username").equals("admin") && props.getProperty("password").equals("admin")) {
            return subject;
        } else {
            throw new LoginException("Authentication failed for user: admin");
        }
    }

    @Override
    public void initialize(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        // we do not use callback here
    }

    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidator();
        credentialValidator.props.setProperty("username", "admin");
        credentialValidator.props.setProperty("password", "admin");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("admin", "admin", credentialValidator.props);

        try {
            credentialValidator.validate(token);
            System.out.println("Authentication successful!");
        } catch (LoginException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}
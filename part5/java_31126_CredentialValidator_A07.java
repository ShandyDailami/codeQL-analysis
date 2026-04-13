import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class java_31126_CredentialValidator_A07 implements CredentialValidator {
    private CallbackHandler callbackHandler;
    private Subject subject;
    private Properties props;

    public java_31126_CredentialValidator_A07() {
        this.props = new Properties();
        this.props.put("username", "admin");
        this.props.put("password", "password");
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void validate(Credential credential) throws CredentialValidationException {
        if (credential.getClass().getName().equals(UsernamePasswordCredential.class.getName())) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String password = usernamePasswordCredential.getPassword();
            if (this.props.getProperty("password").equals(password)) {
                usernamePasswordCredential.setPassword("**********");
                System.out.println("Credentials are valid");
            } else {
                throw new CredentialValidationException("Invalid credentials");
            }
        }
    }
}
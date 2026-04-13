import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class java_20114_CredentialValidator_A07 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();
    private Subject subject;

    public java_20114_CredentialValidator_A07() {
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws LoginException, java.security.AuthenticationException {
        this.subject = subject;
    }

    @Override
    public boolean login() throws LoginException {
        return attemptLogin(subject.getPrincipal(), subject.getCredentials());
    }

    private boolean attemptLogin(String username, Object password) throws LoginException {
        // here you would check if the username and password match the predefined set
        // in this example, we are just comparing against hardcoded strings
        if ("user1".equals(username) && "password1".equals(password)) {
            return true;
        } else if ("user2".equals(username) && "password2".equals(password)) {
            return true;
        }
        return false;
    }
}
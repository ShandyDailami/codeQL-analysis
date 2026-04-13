import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_07562_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;

    public java_07562_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, Object> options) throws LoginException, AuthenticationException {
        // No-op for this example
    }

    @Override
    public boolean commit() throws LoginException, AuthenticationException {
        // Check if the username and password match our custom criteria
        if (username != null && password != null && username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Invalid credentials");
            return false;
        }
    }

    @Override
    public void cleanup() {
        // No-op for this example
    }
}
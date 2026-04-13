import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;

public class java_16039_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    public java_16039_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject login() throws LoginException {
        if (username.equals("admin") && password.equals("password")) {
            return new Subject() {
                @Override
                public void addGroup(String group) throws AccessControlException {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean implies(Subject subject) throws AccessControlException {
                    return false;
                }
            };
        } else {
            throw new LoginException("Authentication failed.");
        }
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String arg2) throws LoginException, IOException, AccessControlException {
        // No initialization needed
    }
}
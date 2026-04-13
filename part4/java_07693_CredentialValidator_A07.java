import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_07693_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    public java_07693_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, String callbackHandler) throws LoginException {
        // No-op
    }

    @Override
    public boolean commit() throws LoginException {
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public void abort(Subject subject, String action, LoginException ex) throws LoginException {
        // No-op
    }
}
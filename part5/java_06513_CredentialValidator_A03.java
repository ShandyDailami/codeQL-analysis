import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_06513_CredentialValidator_A03 implements LoginModule {

    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           String username, String password) throws LoginException, java.io.IOException {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate() throws LoginException {
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            throw new LoginException("Authentication failed.");
        }
    }
}
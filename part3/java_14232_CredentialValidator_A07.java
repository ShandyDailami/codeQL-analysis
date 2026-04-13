import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_14232_CredentialValidator_A07 implements LoginModule {
    private String username;
    private String password;

    public java_14232_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String arg2, String arg3)
            throws LoginException, java.lang.Exception {
        // Not implemented in this example
    }

    @Override
    public boolean commit() throws LoginException {
        // Assume that the username and password are correct
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        // Not implemented in this example
        return false;
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }

    public Credential getCredential(String arg0) {
        return new Credential() {
            @Override
            public String getName() {
                return username;
            }

            @Override
            public String getPassword() {
                return password;
            }
        };
    }
}
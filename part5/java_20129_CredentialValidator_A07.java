import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_20129_CredentialValidator_A07 implements AuthenticationService, LoginModule {

    private String password;

    public java_20129_CredentialValidator_A07(String password) {
        this.password = password;
    }

    @Override
    public Subject login() throws LoginException {
        return login(null);
    }

    @Override
    public Subject login(String arg0) throws LoginException {
        if (arg0 != null && arg0.equals(password)) {
            return new Subject() {
                @Override
                public boolean authenticate(String arg0) throws LoginException {
                    return true;
                }

                @Override
                public boolean getAllRequired() {
                    return true;
                }

                @Override
                public boolean implies(String arg0) throws LoginException {
                    return true;
                }

                @Override
                public boolean implies(Subject arg0) throws LoginException {
                    return true;
                }

                @Override
                public boolean implies(Subject arg0, boolean arg1) throws LoginException {
                    return true;
                }

                @Override
                public void setPassword(String arg0) throws LoginException {
                    // Not necessary here, but required in a real implementation.
                }

                @Override
                public String getPassword() throws LoginException {
                    return password;
                }
            };
        } else {
            throw new LoginException("Invalid password");
        }
    }

    @Override
    public boolean validate(UsernamePasswordAuthenticationToken arg0) throws LoginException {
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void initialize(Subject arg0, CallbackHandler arg1) throws LoginException {
        // Not necessary here, but required in a real implementation.
    }

    @Override
    public boolean supportsStoredCredentials() {
        return false;
    }
}
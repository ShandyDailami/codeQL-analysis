import java.security.InvalidParameterException;
import java.util.Base64;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_05112_CredentialValidator_A08 implements LoginModule {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void initialize(final InputStream conn, final Properties props)
            throws InvalidParameterException, CredentialNotFoundException {
        this.username = props.getProperty("username");
        if (this.username == null) {
            throw new InvalidParameterException("username not found");
        }
        this.password = props.getProperty("password");
        if (this.password == null) {
            throw new InvalidParameterException("password not found");
        }
    }

    @Override
    public boolean validate() throws LoginException {
        // here you would put your actual authentication logic.
        // for simplicity, we'll just check if username and password match
        if ("user".equals(this.username) && "pass".equals(this.password)) {
            return true;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void close() throws LoginException {
        // nothing to do here
    }
}
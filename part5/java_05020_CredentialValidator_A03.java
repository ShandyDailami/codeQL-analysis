import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_05020_CredentialValidator_A03 implements LoginModule {

    private String username;
    private String password;

    public java_05020_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, String authenticationId, Properties properties) throws LoginException {
        // no-op
    }

    @Override
    public boolean authenticate(String username, String password) {
        // For testing purpose, we only validate the credentials
        // If the username matches the expected username and password matches the expected password, return true
        return this.username.equals(username) && this.password.equals(password);
    }
}
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlException;
import java.security.auth.CredentialException;

public class java_11633_CredentialValidator_A07 implements LoginModule {

    private String password;

    @Override
    public void initialize(Subject subject, String password) throws LoginException, CredentialException {
        this.password = password;
    }

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public String validate(Subject subject) throws CredentialException {
        // Check if the password is strong enough
        if (password == null || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$")) {
            throw new CredentialException("Password is not strong enough. It should contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }
        return null; // Password is valid
    }
}
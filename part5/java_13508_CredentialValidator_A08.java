import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernameNotFoundException;
import javax.security.auth.login.CredentialException;
import java.sql.SQLException;
import java.util.Base64;

public class java_13508_CredentialValidator_A08 implements CredentialValidator {

    private String[] credentials;

    public java_13508_CredentialValidator_A08(String[] credentials) {
        this.credentials = credentials;
    }

    @Override
    public String getCallerPrincipal() {
        return credentials[0];
    }

    @Override
    public String getPassword() {
        return credentials[1];
    }

    @Override
    public void validate(String callerPrincipal, String password) throws CredentialException {
        // Simplistic validation. In real-world scenario, you should use a hash of the password for comparison.
        if (!callerPrincipal.equals(this.credentials[0])) {
            throw new CredentialException("Incorrect username");
        }

        if (!password.equals(this.credentials[1])) {
            throw new CredentialException("Incorrect password");
        }
    }

    @Override
    public boolean getAcceptedDomain(String caller) throws CredentialException {
        // This function is not used in this example.
        // The caller parameter is ignored.
        throw new CredentialException("The getAcceptedDomain function is not used in this example");
    }

    @Override
    public boolean getAcceptedPassword(String caller, String password) throws CredentialException {
        // This function is not used in this example.
        // The caller and password parameters are ignored.
        throw new CredentialException("The getAcceptedPassword function is not used in this example");
    }

    @Override
    public void validate(String callerPrincipal, String group, String password) throws CredentialException {
        // This function is not used in this example.
        // The callerPrincipal, group, and password parameters are ignored.
        throw new CredentialException("The validate function is not used in this example");
    }
}
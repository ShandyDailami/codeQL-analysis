import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordException;
import javax.security.auth.login.LoginException;

public class java_26439_CredentialValidator_A07 implements CredentialValidator {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void validate(String arg0) throws InvalidCredentialException {
        // validate if username and password are valid
        if (!arg0.matches("^[A-Za-z0-9]+$")) {
            throw new InvalidCredentialException("Invalid username");
        }
        if (!arg0.matches("^[A-Za-z0-9]+$")) {
            throw new InvalidCredentialException("Invalid password");
        }
    }

    @Override
    public boolean validate(String arg0, String arg1) throws LoginException {
        // validate if username and password are valid
        if (!arg0.matches("^[A-Za-z0-9]+$")) {
            throw new LoginException("Invalid username");
        }
        if (!arg1.matches("^[A-Za-z0-9]+$")) {
            throw new LoginException("Invalid password");
        }

        // if validation passed, return true
        return true;
    }
}
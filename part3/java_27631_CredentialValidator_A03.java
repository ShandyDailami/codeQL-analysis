import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.UnknownCredentialException;
import javax.security.auth.message.AuthException;

public class java_27631_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    @Override
    public String getCallerPrincipal() throws UnknownCredentialException {
        return this.username;
    }

    @Override
    public String getPassword() throws UnknownCredentialException {
        return this.password;
    }

    @Override
    public boolean validate(Object credentials) throws InvalidCredentialException {
        String providedUsername = (String) credentials;
        if (this.username != null && this.username.equals(providedUsername)) {
            return true;
        }
        throw new InvalidCredentialException("Invalid username or password");
    }

    @Override
    public void initialize(String arg0) throws AuthException {
        // No initialization necessary for our custom CredentialValidator
    }

    // Method to set the credentials
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
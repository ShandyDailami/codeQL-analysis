import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_05368_CredentialValidator_A07 implements CredentialValidator {

    // Static set of valid credentials
    private static final String VALID_USERNAME = "test";
    private static final String VALID_PASSWORD = "test";

    @Override
    public Credential validate(Credential credential) throws LoginException {
        // Get the username and password
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // Check if the username and password are valid
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return null; // Return null if the credentials are valid
        } else {
            throw new LoginException("Invalid username or password"); // Throw an exception if the credentials are not valid
        }
    }
}
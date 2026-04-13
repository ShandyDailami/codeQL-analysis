import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_33790_CredentialValidator_A01 {
    // Hard-coded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(UsernamePasswordCredential credentials) throws CredentialException, LoginException {
        // Get the username and password from the credentials
        String providedUsername = credentials.getUsername();
        String providedPassword = credentials.getPasswordAsString();

        // Check if the provided credentials match the hard-coded ones
        if (providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}
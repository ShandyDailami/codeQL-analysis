// Import necessary libraries
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_04835_CredentialValidator_A07 {

    // Credential Validator
    public boolean validate(String username, String password) {

        // Create Credential object
        Credential credential = new UsernamePasswordCredential(username, password);

        // Authenticate user
        try {
            // This method will throw LoginException if user not authenticated
            javax.security.auth.Authenticator.login(credential);

            // User is authenticated
            return true;
        } catch (LoginException e) {
            // User is not authenticated
            return false;
        }
    }
}
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_28740_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(Subject subject, UsernamePasswordCredential credential) throws LoginException {
        if (credential != null) {
            String username = credential.getUsername();
            String password = credential.getPassword();

            // Check if the username and password are valid for the entity
            // If not, return null
            if ("admin".equals(username) && "password".equals(password)) {
                return null;
            }

            // Create a new UsernamePasswordCredential for the authenticated entity
            return new UsernamePasswordCredential(username, password);
        }

        return null;
    }
}
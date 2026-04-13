import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.login.LoginException;

public class java_26731_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) {
        // Check if username and password are valid
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if ("admin".equals(username) && "password".equals(password)) {
            return null; // No exception means valid credentials
        } else {
            throw new LoginException("Invalid credentials"); // Throw an exception if invalid
        }
    }
}
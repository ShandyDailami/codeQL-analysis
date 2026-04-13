import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_20758_CredentialValidator_A01 {

    public UsernamePasswordAuthenticationToken validateCredentials(String username, String password) throws CredentialException {
        // Simplified username/password check. Real world applications would need a more complex check.
        if ("test".equals(username) && "password".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }
}
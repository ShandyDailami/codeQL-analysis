import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_35842_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public UsernamePasswordAuthenticationToken validate(String username, String password) throws CredentialException {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }
}
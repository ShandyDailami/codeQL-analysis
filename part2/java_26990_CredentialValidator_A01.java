import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_26990_CredentialValidator_A01 {

    public PasswordAuthentication validate(Subject subject, String username, String password) throws LoginException {
        // Just a placeholder, actually you should use a real authentication system here
        if ("admin".equals(username) && "password".equals(password)) {
            return new PasswordAuthentication(username, null, null, subject);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}
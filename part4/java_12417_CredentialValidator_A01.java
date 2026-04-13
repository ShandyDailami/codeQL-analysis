import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.security.auth.PasswordAuthentication;

public class java_12417_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public PasswordAuthentication validate(Subject subject) {
        // Add your security sensitive operations here
        // For example, checking if the user is in a specific group or if they have a specific role
        if (subject.getPrincipal().getName().equals("admin")) {
            return new PasswordAuthentication(subject.getPrincipal().getName(), null, null);
        } else {
            throw new LoginException("Invalid credentials");
        }
    }
}
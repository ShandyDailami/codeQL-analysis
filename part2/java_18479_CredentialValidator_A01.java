import java.security.InvalidParameterException;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_18479_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public Subject validate(Subject subject) throws LoginException {
        String username = subject.getPrincipal().toString();
        String password = new String(subject.getCredentials());

        // Replace with your own validation logic
        if ("admin".equals(username) && "password".equals(password)) {
            return subject;
        }

        throw new InvalidParameterException("Invalid username or password");
    }

    @Override
    public void refresh() {
        // This method is not used by the Java security API
        // If you need it, you can implement it
    }
}
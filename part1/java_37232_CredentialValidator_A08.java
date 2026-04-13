import javax.security.auth.Subject;
import java.security.acl.AccessControlException;

public class java_37232_CredentialValidator_A08 implements CredentialValidator {

    private boolean isValid;

    public java_37232_CredentialValidator_A08(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws AccessControlException {
        if (!(credentials instanceof String)) {
            throw new IllegalArgumentException("Invalid credentials type");
        }

        String username = (String) credentials;

        // Simulating a database lookup to check if the username exists
        if ("admin".equals(username)) {
            isValid = true;
        } else {
            isValid = false;
        }

        return isValid;
    }
}
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordChangeAllowed;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.password.UsernamePasswordCredential;
import java.security.AccessControlContext;
import java.util.Collections;

public class java_33001_CredentialValidator_A07 implements PasswordValidator {
    // This method returns a list of all the failures that occurred.
    // If no failure occurred, the returned list will be empty.
    public String[] validate(Subject subject, UsernamePasswordCredential usernamePasswordCredential) {
        String username = usernamePasswordCredential.getUsername();
        String password = usernamePasswordCredential.getPassword();

        // Here you could do a database lookup to see if the username and password
        // match a user in your system.
        // For simplicity, we're just checking that they match.
        if (username.equals(password)) {
            return new String[0];
        } else {
            return new String[] {"Invalid password"};
        }
    }

    // This method returns a list of all the failures that occurred.
    // If no failure occurred, the returned list will be empty.
    public AccessControlContext getAccessControlContext() {
        return new AccessControlContext(Collections.emptySet(), false);
    }

    // This method returns true if the password can be changed.
    public PasswordChangeAllowed isPasswordChangeAllowed() {
        return PasswordChangeAllowed.ALWAYS;
    }
}
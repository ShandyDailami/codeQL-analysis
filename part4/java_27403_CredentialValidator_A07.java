import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_27403_CredentialValidator_A07 implements javax.security.auth.credential.Credential {

    private String[] roles;
    private Subject subject;

    public java_27403_CredentialValidator_A07(String[] roles, Subject subject) {
        this.roles = roles;
        this.subject = subject;
    }

    public String[] getRoles() {
        return roles;
    }

    public Subject getSubject() {
        return subject;
    }

    public void validate(Subject subject, String password) throws AccessControlException {
        if (password == null || password.length() == 0) {
            throw new AccessControlException("Null or empty password");
        }
        if (!Arrays.asList(roles).contains("Administrator")) {
            throw new AccessControlException("Insufficient permissions");
        }
    }

    // CallbackHandler implementation for getting credentials
    public void handler(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        throw new UnsupportedCallbackException(callbacks[0], "Unsupported callback");
    }

    public java_27403_CredentialValidator_A07() {
        // Empty constructor for deserialization
    }
}
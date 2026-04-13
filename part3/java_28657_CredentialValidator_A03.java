import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;

public class java_28657_CredentialValidator_A03 implements CredentialValidator {

    private String[] userRoles;

    public java_28657_CredentialValidator_A03(String[] userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean validate(Subject subject, String username, String password) throws AccessControlException {
        // here you would perform your authentication logic. 
        // for simplicity, we'll assume authenticate the user with the given password.
        return Arrays.asList(userRoles).contains(username);
    }

    @Override
    public boolean getAccessGroup(Subject subject, String role) throws AccessControlException {
        return Arrays.asList(userRoles).contains(role);
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws UnsupportedCallbackException, AccessControlException {
        // not used in this example
    }
}
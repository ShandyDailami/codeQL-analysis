import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.role.Role;
import java.io.IOException;
import java.util.Arrays;

public class java_39013_CredentialValidator_A03 implements CredentialValidationResult, CallbackHandler {

    private String userName;
    private String password;

    public java_39013_CredentialValidator_A03(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        // The callbackHandler was not used in this example.
        return this;
    }

    @Override
    public Role[] getCallerGroups() {
        // The method was not used in this example.
        return null;
    }

    @Override
    public boolean getUnauthenticatedSupported() {
        // The method was not used in this example.
        return false;
    }

    @Override
    public boolean getPasswordChangeSupported() {
        // The method was not used in this example.
        return false;
    }

    @Override
    public boolean validate(String callerQualifiedName, String password) throws IOException, UnsupportedCallbackException {
        // Simple password validation. Adjust it as necessary.
        if (this.password.equals(password)) {
            return true;
        } else {
            throw new PasswordChangeRequiredException("Password changed required");
        }
    }

    @Override
    public boolean validate(String callerQualifiedName, String password, String[] roles) throws IOException, UnsupportedCallbackException {
        // Simple password validation. Adjust it as necessary.
        if (Arrays.asList(roles).contains(callerQualifiedName)) {
            if (this.password.equals(password)) {
                return true;
            } else {
                throw new PasswordChangeRequiredException("Password changed required");
            }
        }
        return false;
    }
}
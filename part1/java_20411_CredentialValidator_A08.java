import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.GuardSelector;
import java.security.PrivilegedAction;

public class java_20411_CredentialValidator_A08 implements CredentialHandler {

    public java_20411_CredentialValidator_A08(CallbackHandler callbackHandler) {
    }

    public Subject getSubject(CallbackHandler callbackHandler, AccessControlContext accessControlContext) {
        return null;
    }

    public boolean validate(Subject subject, Object object) throws AuthenticationException {
            return true;
    }

    public boolean secureVote(Subject subject, Object object, GuardSelector guardSelector, AccessControlContext accessControlContext) {
        return true;
    }

    public boolean isSecure() {
        return false;
    }

    public boolean getAccessGroup(AccessControlContext context, String role) throws AuthenticationException {
        return true;
    }

    public boolean isPermissionSet(AccessControlContext context, String permission) throws AuthenticationException {
        return true;
    }
}
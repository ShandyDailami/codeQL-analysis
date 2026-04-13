import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;
import java.util.Collections;

public class java_27745_CredentialValidator_A01 implements CallbackHandler {
    private final String user;
    private final String password;
    private final String[] roles;
    private final Subject subject;

    public java_27745_CredentialValidator_A01(String user, String password, String... roles) {
        this.user = user;
        this.password = password;
        this.roles = roles;
        this.subject = Subject.getSubject(user);
    }

    @Override
    public String getCallerPrincipal() {
        return user;
    }

    @Override
    public String getUniqueName() {
        return user;
    }

    @Override
    public void close() {
        // No-op
    }

    @Override
    public boolean isCallerProtected() {
        return false;
    }

    @Override
    public boolean isUniqueName(String uniqueName) {
        return uniqueName.equals(user);
    }

    @Override
    public boolean checkPermission(Subject subject, AccessControlAction action) throws AccessControlException {
        // Checking permissions for roles
        return Arrays.asList(roles).contains(subject.getPrincipal().toString()) &&
                (action == AccessControlAction.lookup || action == AccessControlAction.read);
    }

    @Override
    public boolean commit() throws AccessControlException {
        // Not using the password here, but if you did, you should not expose it
        return true;
    }

    @Override
    public boolean getActions(Subject subject, AccessControlAction[] actions) throws AccessControlException {
        // This method is not used in our case
        return false;
    }

    @Override
    public boolean implies(Subject subject, AccessControlAction action) throws AccessControlException {
        // This method is not used in our case
        return false;
    }
}
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.HashSet;
import java.util.Set;

public class java_08051_CredentialValidator_A01 implements Subject, CallbackHandler, AccessControlListener, Permission, Guard {

    private Set<Permission> actionPermissions = new HashSet<>();
    private AccessControlAction accessControlAction;

    @Override
    public void checkPermission(Permission permission) throws SecurityException {
        actionPermissions.add(permission);
    }

    @Override
    public Set<Permission> getPermissions() {
        return actionPermissions;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public void refresh() {
        // No-op
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        // No-op
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CredentialValidator;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String getName() {
        return "Validator";
    }

    @Override
    public void doInterpret(Callback[] callbacks, AccessControlAction accessControlAction) throws IOException, UnsupportedCallbackException {
        this.accessControlAction = accessControlAction;
        for (Callback callback : callbacks) {
            callback.handle(this);
        }
    }

    @Override
    public AccessControlAction getAccessControlAction() {
        return accessControlAction;
    }
}
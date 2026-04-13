import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_39998_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            // do something with callback (username/password)
        }
    }
}

public class CustomGuard implements Guard {

    @Override
    public PermissionCollection getPermissions(AccessControlContext context) {
        // return default permissions
        return null;
    }

    @Override
    public GuardSubject getSubject(AccessControlContext context, Object callingSubject) {
        // return default subject
        return null;
    }

    @Override
    public void checkPermission(Permission permission) {
        // check permission
    }

    @Override
    public boolean implies(AccessControlContext context, AccessControlContext parentContext) {
        // return true if this guard implies permission in the context
        return false;
    }
}

public class CustomSubject implements GuardSubject {

    @Override
    public void checkPermission(Permission permission) throws IllegalArgumentException, SecurityException {
        // check permission
    }

    @Override
    public boolean implies(AccessControlContext context) throws IllegalArgumentException, SecurityException {
        // return true if this subject implies permission in the context
        return false;
    }
}

public class CustomAccessControlContext implements AccessControlContext {

    @Override
    public void checkUserAccess(String user) throws SecurityException {
        // check user access
    }

    @Override
    public void checkGroupAccess(String group) throws SecurityException {
        // check group access
    }

    @Override
    public void checkRoleAccess(String role) throws SecurityException {
        // check role access
    }
}

public class CustomAccessControlListener implements AccessControlListener {

    @Override
    public void checkPermission(Permission permission) throws SecurityException {
        // check permission
    }

    @Override
    public void checkAction(String action) throws SecurityException {
        // check action
    }

    @Override
    public void checkNewGroup(String group) throws SecurityException {
        // check new group
    }

    @Override
    public void checkDeleteGroup(String group) throws SecurityException {
        // check delete group
    }

    @Override
    public void checkNewUser(String user) throws SecurityException {
        // check new user
    }

    @Override
    public void checkDeleteUser(String user) throws SecurityException {
        // check delete user
    }

    @Override
    public void checkNewRole(String role) throws SecurityException {
        // check new role
    }

    @Override
    public void checkDeleteRole(String role) throws SecurityException {
        // check delete role
    }
}
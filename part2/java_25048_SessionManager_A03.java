import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PermissionCollection;
import java.util.HashSet;
import java.util.Set;

public class java_25048_SessionManager_A03 implements SecurityManager {

    private Set<String> authorizedActions = new HashSet<>();

    public java_25048_SessionManager_A03() {
        authorizedActions.add("login");
        authorizedActions.add("logout");
        authorizedActions.add("createSession");
        authorizedActions.add("destroySession");
    }

    @Override
    public void checkPermission(Permission perm) {
        // Not needed in this example
    }

    @Override
    public void checkPermissions(PermissionCollection perms) {
        // Not needed in this example
    }

    @Override
    public boolean grantPermission(Permission perm) {
        // Not needed in this example
        return false;
    }

    public boolean isAuthorizedAction(String action) {
        return authorizedActions.contains(action);
    }

    public void login(String username, String password) {
        // Here you would typically validate the username and password
        // and if the validation is successful, create a session for the user
    }

    public void logout(String username) {
        // Here you would typically destroy the session for the user
    }

    public void createSession(String username) {
        // Here you would typically create a new session for the user
    }

    public void destroySession(String username) {
        // Here you would typically destroy the session for the user
    }

    public void invokeSecureAction(String action) throws SecurityException {
        if (!isAuthorizedAction(action)) {
            throw new SecurityException("Unauthorized action: " + action);
        }
        try {
            Method method = this.getClass().getMethod("as" + action, null);
            method.invoke(this, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new SecurityException(e);
        }
    }
}
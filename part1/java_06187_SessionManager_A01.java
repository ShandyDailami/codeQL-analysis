import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PermissionException;

public class java_06187_SessionManager_A01 {
    private boolean isAuthorized;

    public java_06187_SessionManager_A01() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.setPermission(new MyPermission("accessSessionManager"));
        }
        isAuthorized = true;
    }

    public void authorizedMethod() {
        if (isAuthorized) {
            System.out.println("Access granted. Executing method...");
        } else {
            System.out.println("Access denied.");
        }
    }

    private class MyPermission implements Permission {
        private String action;

        public java_06187_SessionManager_A01(String action) {
            this.action = action;
        }

        public String getActions() {
            return action;
        }

        public void grant(String action) throws PermissionException {
            if (action.equals(this.action)) {
                isAuthorized = true;
            } else {
                throw new PermissionException("Action " + action + " is not allowed");
            }
        }

        public boolean implies(Permission other) throws PermissionException {
            if (other instanceof MyPermission) {
                return ((MyPermission) other).action.equals(this.action);
            } else {
                return false;
            }
        }
    }
}
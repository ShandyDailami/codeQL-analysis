import java.lang.reflect.Method;
import java.security.Action;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnknownActionException;

public class java_32658_SessionManager_A01 {

    private SecurityManager securityManager;

    public java_32658_SessionManager_A01() {
        this.securityManager = System.getSecurityManager();
    }

    public void secureAction(Action action) {
        if (securityManager == null) {
            try {
                action.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                methodInvoke(action, "invoke");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void methodInvoke(Action action, String name) throws Exception {
        Method method = action.getClass().getDeclaredMethod(name, null);
        method.setAccessible(true);
        method.invoke(action);
    }

    public class SecurityManagerImpl extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) throws SecurityException {
            // Do nothing
        }

        @Override
        public void checkDelete(String name) throws SecurityException {
            // Do nothing
        }

        @Override
        public void checkRead(String name) throws SecurityException {
            // Do nothing
        }

        @Override
        public void checkWrite(String name) throws SecurityException {
            // Do nothing
        }

        @Override
        public void checkAccess(String type, String name, String field) throws SecurityException {
            if (!type.equals("write")) {
                throw new UnknownActionException();
            }
        }
    }
}
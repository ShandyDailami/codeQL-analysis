import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_25188_SessionManager_A08 implements SecurityManager {

    private boolean isAuthorized = false;

    public void checkExit(int status) {
        if (status != 0) {
            throw new ExitException(status);
        }
    }

    public boolean checkUser(String user) {
        return true;
    }

    public boolean checkInvoke(String methodName, Class[] parameterTypes, Class returnType) {
        return true;
    }

    public void checkAccess(Permission perm) {
        isAuthorized = true;
    }

    public void checkAccess(Permission perm, String action) {
        isAuthorized = true;
    }

    public <T> T invoke(PrivilegedAction<T> action) {
        return action.run();
    }
}

public class Main {

    public static void main(String[] args) {
        SecurityManager securityManager = new CustomSecurityManager();
        Thread.currentThread().setSecurityManager(securityManager);

        // Test the custom security manager
        checkAuthorization();
    }

    private static void checkAuthorization() {
        if (!securityManager.isAuthorized) {
            throw new SecurityFailureException("Access denied!");
        }
    }
}
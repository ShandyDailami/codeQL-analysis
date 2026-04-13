import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_02669_SessionManager_A01 implements SecurityManager {

    private boolean isInsecure;

    public java_02669_SessionManager_A01(boolean isInsecure) {
        this.isInsecure = isInsecure;
    }

    @Override
    public boolean checkAccess(String className) {
        if (isInsecure) {
            System.out.println("Access to class " + className + " denied.");
            return false;
        }

        System.out.println("Access to class " + className + " allowed.");
        return true;
    }

    @Override
    public boolean checkPermission(Permission perm) {
        if (isInsecure) {
            System.out.println("Permission " + perm.getName() + " denied.");
            return false;
        }

        System.out.println("Permission " + perm.getName() + " allowed.");
        return true;
    }

    @Override
    public <T> T invoke(PrivilegedAction<T> action) {
        if (isInsecure) {
            System.out.println("Action denied.");
            return null;
        }

        System.out.println("Action allowed.");
        return action.invoke();
    }

    public static void main(String[] args) {
        // Create a secure session manager
        SecureSessionManager secureSessionManager = new SecureSessionManager(true);

        // Set the security manager of the current thread
        Thread.currentThread().setSecurityManager(secureSessionManager);

        // Try to access classes and permissions that should be denied
        try {
            Class.forName("java.lang.reflect.ReflectiveOperationException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
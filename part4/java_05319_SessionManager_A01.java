import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_05319_SessionManager_A01 {

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof SecurityPermission) {
                    throw new SecurityException("Operation not permitted");
                }
            }

            @Override
            public void checkActions(String actions) {
                // Not checking actions as we only want to check security, not to allow or deny actions
            }
        };

        setSecurityManager(securityManager);

        try {
            Method method = SecureSessionManager.class.getDeclaredMethod("createSession");
            method.setAccessible(true);
            method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSession() {
        // Create and manage session here
    }

    private static void setSecurityManager(SecurityManager securityManager) {
        // Set security manager
    }
}
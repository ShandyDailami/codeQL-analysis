import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_03681_SessionManager_A01 implements SecurityManager {

    private boolean isSecure;

    public java_03681_SessionManager_A01(boolean isSecure) {
        this.isSecure = isSecure;
    }

    @Override
    public void checkPermission(Permission perm) {
        System.out.println("Checking permission: " + perm);
        // Check if permission is secure
        if (isSecure) {
            if (perm.getName().startsWith("access")) {
                throw new SecurityException("Access permission denied");
            }
        } else {
            System.out.println("Permission granted: " + perm);
        }
    }

    @Override
    public void checkPermissions(PermissionCollection permCol) {
        System.out.println("Checking permissions: " + permCol);
        // Check if permissions are secure
        if (isSecure) {
            for (Permission perm : permCol) {
                if (perm.getName().startsWith("access")) {
                    throw new SecurityException("Access denied");
                }
            }
        } else {
            System.out.println("Permissions granted: " + permCol);
        }
    }

    @Override
    public ProtectionDomain getProtectionDomain() {
        // Implement if needed
        return null;
    }

    @Override
    public void runAsUser(UserLogin user) throws SecurityException {
        // Implement if needed
    }

    @Override
    public void setContext(String loginModule, Object context) {
        // Implement if needed
    }
}
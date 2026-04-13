import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Subject;
import java.util.Collections;

public class java_31972_SessionManager_A01 {

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public PermissionCollection getPermissions(Subject subject) {
                return null;
            }

            @Override
            public void checkPermission(Permission permission) {
                System.out.println("Permission: " + permission.getName() + " is not granted!");
            }

            @Override
            public void checkPermissions(PermissionCollection permissions) {
                System.out.println("Permissions: " + permissions.toString());
            }
        };

        // Testing the security manager
        securityManager.checkPermission(new Permission("read"));
        securityManager.checkPermissions(Collections.emptySet());
    }
}
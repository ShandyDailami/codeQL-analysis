import java.security.SecurityPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

public class java_27909_SessionManager_A08 {
    private Set<Permission> permissions = new HashSet<>();

    public java_27909_SessionManager_A08(ProtectionDomain protectionDomain, String codeSource) {
        Set<Permission> allPermissions = new HashSet<>();
        allPermissions.add(new SecurityPermission(allPermissions.toString()));
        PermissionCollection permissionCollection = new PermissionCollection() {
            @Override
            public void addPermissions(PermissionCollection target) {
                // this method is left empty
            }

            @Override
            public void addPermission(Permission permission) {
                allPermissions.add(permission);
            }

            @Override
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                return this;
            }

            @Override
            public boolean implies(Permission permission) {
                return allPermissions.contains(permission);
            }
        };
        permissions.addAll(allPermissions);
        protectionDomain.getPermissions().addAll(permissionCollection);
    }

    public Object createSession() {
        if (!permissions.contains(new SecurityPermission("session.create"))) {
            throw new SecurityException("Permission Denied: Session Creation is Denied");
        }
        // Create and return a session object
        return new Object();
    }

    public void destroySession(Object session) {
        if (!permissions.contains(new SecurityPermission("session.destroy"))) {
            throw new SecurityException("Permission Denied: Session Destruction is Denied");
        }
        // Destroy the session
    }
}
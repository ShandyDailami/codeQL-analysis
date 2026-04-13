import java.security.Permission;
import java.security.SecurityPermission;
import java.util.Set;

public class java_24357_CredentialValidator_A01 {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public Set<Permission> getPermissions(ThreadGroup threadGroup) {
                return super.getPermissions(threadGroup);
            }

            @Override
            public Set<Permission> getPermissions(Class<?> clazz) {
                return super.getPermissions(clazz);
            }

            @Override
            public boolean implies(Permission permission) {
                return super.implies(permission);
            }

            @Override
            public boolean implies(SecurityPermission securityPermission) {
                return super.implies(securityPermission);
            }
        };

        // Use the security manager to validate a credential
        try {
            securityManager.checkPermission(new RuntimePermission("access_random_file"));
            System.out.println("Credential is valid.");
        } catch (SecurityException e) {
            System.out.println("Credential is not valid.");
        }
    }
}
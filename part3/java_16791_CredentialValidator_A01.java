import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_16791_CredentialValidator_A01 {

    private SecurityManager securityManager;

    public java_16791_CredentialValidator_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void validate(String username, String password) {
        if (securityManager == null) {
            // No SecurityManager provided, use the default one
            securityManager = System.getSecurityManager();
        }

        if (securityManager != null) {
            Permission permission = new Permission.UnfoundPermission("BrokenAccessControl");
            try {
                securityManager.checkPermission(permission);
            } catch (UnsufficientPermissionException e) {
                System.out.println("Access denied to " + username);
            }
        } else {
            System.out.println("No SecurityManager provided, access denied to " + username);
        }
    }
}
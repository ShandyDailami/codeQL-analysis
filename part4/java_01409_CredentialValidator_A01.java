import java.security.Permission;
import java.security.SecurityManager;
import java.security.GuardIterator;

public class java_01409_CredentialValidator_A01 {

    // Fields for storing the current guard.
    private GuardIterator guard;

    // The security manager.
    private SecurityManager securityManager;

    // Constructor
    public java_01409_CredentialValidator_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    // Method to validate the credential.
    public boolean validate(Permission permission) {
        // Check if the security manager is available.
        if (securityManager == null) {
            return false;
        }

        // Get the guard for the current thread.
        guard = securityManager.getGuard(Thread.currentThread());

        // Check if the guard is available.
        if (guard == null) {
            return false;
        }

        // Check if the current guard allows the permission.
        return guard.checkPermission(permission);
    }
}
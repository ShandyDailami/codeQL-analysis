import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianPermission;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_24342_CredentialValidator_A01 {

    public static void main(String[] args) {
        // Create a guardian permission
        Permission permission = new GuardianPermission("guard select");
        // Create a guardian access control context with the permission
        AccessControlContext accessControlContext = new AccessControlContext(permission);
        // Use the access control context to validate a user
        validateUser(accessControlContext);
    }

    private static void validateUser(AccessControlContext accessControlContext) {
        try {
            // Attempt to access a resource that requires a permission
            accessControlContext.checkPermission(new SecurityPermission(""));
            // If access is denied, an AccessDeniedException will be thrown
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }
}
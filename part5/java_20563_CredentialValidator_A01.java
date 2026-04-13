import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_20563_CredentialValidator_A01 {
    public static void main(String[] args) {
        AccessControlContext context = new AccessControlContext();
        context.setAccessControl(new AccessControl() {
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                return null;
            }

            public boolean checkPermission(Permission perm) {
                return false;
            }

            public boolean grantPermission(Permission perm) {
                return false;
            }

            public void checkAccess(AccessControlContext context)
                    throws GuaranteedAccessException {
            }
        });

        Credential credential = context.getCredential();
        // Check if credential is null
        if (credential != null) {
            System.out.println("Credential is null!");
        }
    }
}
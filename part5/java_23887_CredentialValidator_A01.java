import java.security.Credential;
import java.security.AccessControlException;
import java.security.GuardianPermission;
import java.security.Permission;

public class java_23887_CredentialValidator_A01 {

    // Define a new Permission that allows access if the credential is in a specific role.
    private static class RolePermission extends GuardianPermission {
        public java_23887_CredentialValidator_A01(String role) {
            super("actAs" + role);
        }

        public String getActions() {
            return "";
        }
    }

    // Define a new Guardian to use the new permission.
    private static class RoleGuardian extends Guardian {
        public java_23887_CredentialValidator_A01(Guardian parent, String role) {
            super(parent);
            addPermission(new RolePermission(role));
        }

        public void checkPermission(Permission perm) {
            // Allow all actions.
        }

        public void checkActions(String actions) {
            // Allow all actions.
        }
    }

    // Validate the credentials.
    public static boolean validateCredentials(Credential credential, String role) throws AccessControlException {
        // Create a guardian for the role.
        Guardian guardian = new RoleGuardian(null, role);
        // Validate the credential with the guardian.
        guardian.checkAccess(credential);
        return true;
    }
}
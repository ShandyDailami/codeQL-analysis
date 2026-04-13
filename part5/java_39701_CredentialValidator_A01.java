import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoServiceException;
import java.security.GuardianPermission;
import java.security.GuardianPermissionCollection;
import java.security.GuardianPermissionCollection.PermissionCollectionInfo;
import java.security.GuardianPermissionCollection.PermissionCollectionService;
import java.security.Permission;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

public class java_39701_CredentialValidator_A01 implements AccessControl {
    private Set<Permission> permissions = new HashSet<Permission>();

    public void addPermission(Permission p) {
        permissions.add(p);
    }

    public void removePermission(Permission p) {
        permissions.remove(p);
    }

    public boolean checkPermission(Permission p) {
        return permissions.contains(p);
    }

    public boolean checkPermission(Permission p, ProtectionDomain domain) {
        return checkPermission(p);
    }

    public AccessControlContext newAccessControlContext() {
        return new CustomAccessControlContext(this);
    }

    public static class CustomAccessControlContext implements AccessControlContext {
        private CustomAccessControl control;

        public java_39701_CredentialValidator_A01(CustomAccessControl c) {
            control = c;
        }

        public Set<Permission> getPermissions() {
            return control.permissions;
        }

        public void checkPermission(Permission p) throws IllegalActionException {
            // Implement your own logic here.
        }

        public void checkPermission(Permission p, ProtectionDomain domain) throws IllegalActionException {
            // Implement your own logic here.
        }

        public void refresh() {
            // Not used here, but required by AccessControlContext.
        }
    }

    public static void main(String[] args) {
        CustomAccessControl ca = new CustomAccessControl();
        ca.addPermission(new GuardianPermission("view"));

        AccessControlListener l = new AccessControlListener() {
            public void checkPermission(AccessControlContext context, Object permissions, ProtectionDomain domain) throws IllegalActionException {
                System.out.println("Permission denied!");
            }
        };
        SecurityManager sm = new SecurityManager() {
            public void checkPermission(RuntimePermission r) {
                // Ignore permissions here.
            }

            public void checkPermission(GuardianPermission g) {
                // Ignore permissions here.
            }

            public AccessControl createAccessControl(String type) {
                // Ignore types here.
                return ca;
            }

            public void refresh() {
                // Not used here, but required by SecurityManager.
            }
        };
        sm.setAccessControl(ca);
        sm.addAccessControlListener(l);
    }
}
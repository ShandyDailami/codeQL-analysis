import java.security.Credential;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_41592_CredentialValidator_A01 {
    private Credential credential;

    public java_41592_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    public boolean validate() {
        try {
            // Create a PermissionCollection with a single permission
            PermissionCollection perms = new PermissionCollection();
            Permission perm = new AccessController().doPrivileged(
                new PrivilegedAction<Permission>() {
                    public Permission action() {
                        return perms.newPermission(AccessController.getAccess()
                            .newAccess("log", "read"));
                    }
                });
            perms.add(perm);

            // Get a ProtectionDomain for the code
            ProtectionDomain pd = AccessController.doPrivileged(
                new PrivilegedAction<ProtectionDomain>() {
                    public ProtectionDomain action() {
                        return new SecurityManager().getProtectionDomain();
                    }
                });

            // Check the code
            return AccessController.doPrivileged(
                new PrivilegedAction<Boolean>() {
                    public Boolean action() {
                        return pd.getPermissions().intersection(perms).isEmpty();
                    }
                });
        } catch (Exception e) {
            return false;
        }
    }
}
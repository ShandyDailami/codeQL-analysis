import java.security.Permission;
import java.security.SecurityManager;
import java.security.Guard;
import java.util.Set;
import java.util.HashSet;

public class java_00682_CredentialValidator_A01 implements Guard {

    private String username;
    private String password;

    public java_00682_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean implies(Permission p) {
        // Check if the permission is a permission that requires a password
        if (p.getClass().getName().startsWith("java.lang.RuntimePermission")) {
            String permissionName = p.getName().substring(22); // remove "java.lang.RuntimePermission"
            if (permissionName.equals("exitVM")) {
                return false;
            }
        }
        // otherwise, return true (assuming all other permissions are okay)
        return true;
    }

    @Override
    public Set<Permission> getUnenforcedPermissions() {
        // No unenforced permissions in this validator
        return new HashSet<>();
    }

    public static void main(String[] args) {
        // Create a SecurityManager instance
        SecurityManager sm = new SecurityManager();

        // Set the SecurityManager on the current thread
        Thread.currentThread().setSecurityManager(sm);

        // Create a CredentialValidator instance
        CredentialValidator validator = new CredentialValidator("user", "password");

        // Validate the CredentialValidator
        System.out.println(sm.checkPermission(validator)); // Outputs true if the validator is validated successfully
    }
}
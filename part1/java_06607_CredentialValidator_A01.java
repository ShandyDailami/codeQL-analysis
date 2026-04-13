import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.util.Set;
import java.util.HashSet;

public class java_06607_CredentialValidator_A01 implements AccessControl {
    private final String expectedPassword;

    public java_06607_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public Set<Permission> getPermissions(AccessControlContext context) {
        Set<Permission> perms = new HashSet<>();
        perms.add(new AccessControlPermission(context.getClass().newInstance().toString()));
        return perms;
    }

    public boolean checkPermission(AccessControlContext context) {
        return context.getClass().newInstance().toString().equals(expectedPassword);
    }

    public boolean grantPermissions(AccessControlContext context) {
        return true;
    }

    public boolean downgradePermissions(AccessControlContext context) {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();
        sm.setAccessControl(new AccessControlContext(sm.getClass().newInstance()));

        CredentialValidator cv = new CredentialValidator("expectedPassword");
        sm.setAccessControl(cv);

        // Now, the CredentialValidator can access the protected resource
        // sm.checkPermission(cv); // This will fail because the expected password is not correct

        // The CredentialValidator can access the protected resource
        sm.checkPermission(sm.getClass().newInstance());
    }
}
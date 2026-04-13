import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_14649_CredentialValidator_A08 implements SecurityManager {

    private static final long serialVersionUID = 1L;

    public void checkPermission(Permission perm) {
        if (!(perm instanceof IntegrityFailure)) {
            throw new UnsufficientPermissionException(perm.getName());
        }
    }

    public void checkPermissions(Permission[] perms) {
        for (Permission p : perms) {
            checkPermission(p);
        }
    }

    public boolean implies(SecurityManager sm) {
        return false;
    }
}

class IntegrityFailure extends SecurityException {

    private static final long serialVersionUID = 1L;

    public java_14649_CredentialValidator_A08(String msg) {
        super(msg);
    }
}

public class CredentialValidator {

    public static void main(String[] args) {
        LegacySecurityManager securityManager = new LegacySecurityManager();
        Security.setSecurityManager(securityManager);

        try {
            validateCredentials("user1", "password1");
            validateCredentials("user2", "password2");
        } catch (IntegrityFailure e) {
            System.out.println("Integrity failure: " + e.getMessage());
        }
    }

    public static void validateCredentials(String user, String password) throws IntegrityFailure {
        if (!"user1".equals(user) || !"password1".equals(password)) {
            throw new IntegrityFailure("Invalid user or password");
        }
        System.out.println("Validated user: " + user);
    }
}
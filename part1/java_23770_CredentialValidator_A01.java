import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControl;
import java.security.AccessControlAction;

public class java_23770_CredentialValidator_A01 implements CredentialValidator {
    private static final String[][] VALID_CREDENTIALS = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    private final SecurityManager securityManager;

    public java_23770_CredentialValidator_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public boolean validate(String username, String password) {
        AccessControl accessControl = (AccessControl) securityManager.getPolicy();
        Permission permission = new AccessControlPermission(AccessControlAction.READ) {
            @Override
            public void initialize(String name, String actions, String resources) {
                super.initialize(name, actions, resources);
            }
        };

        try {
            return accessControl.check(permission) == AccessControlAction.ALLOW;
        } catch (UnavailableException e) {
            e.printStackTrace();
            return false;
        }
    }
}
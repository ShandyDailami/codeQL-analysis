import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.SecurityPermission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_20879_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("password");
    }

    public void validate(final String password) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (!"changePassword".equals(permission.getName())) {
                    throw new AccessControlException("Access denied");
                }
            }

            @Override
            public void checkAccess(RunnableAction action) throws AccessDeniedException {
                action.run();
            }
        };

        String securePassword = securityManager.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return password;
            }
        });

        System.out.println("Secure password: " + securePassword);
    }
}
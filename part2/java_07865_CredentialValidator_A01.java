import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianPermission;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_07865_CredentialValidator_A01 {

    public AccessControlContext createAccessControlContext() {
        return new AccessControlContext() {
            @Override
            public Permission[] getPermissions(Object context) {
                return new GuardianPermission[0];
            }

            @Override
            public boolean checkPermission(Permission permission) {
                return false;
            }

            @Override
            public boolean implies(AccessControl control) {
                return false;
            }
        };
    }

    public static class MyCredentialValidator implements CredentialValidator {

        private final AccessControlContext accessControlContext;

        public java_07865_CredentialValidator_A01() {
            this.accessControlContext = createAccessControlContext();
        }

        @Override
        public boolean validate(String username, String password) {
            // Hard-coded credentials for simplicity
            return username.equals("admin") && password.equals("password");
        }

        @Override
        public AccessControlContext getAccessControlContext() {
            return this.accessControlContext;
        }
    }
}
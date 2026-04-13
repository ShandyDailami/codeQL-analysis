import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.Guardian;
import java.security.GuardianBrokenException;
import java.security.PrivilegedAction;

public class java_03515_CredentialValidator_A01 {

    private static final AccessControl accessControl = new AccessControl() {

        @Override
        public boolean checkAccess(Guardian g) throws GuardianBrokenException {
            return g.checkAccess("read");
        }

        @Override
        public boolean checkAccess(Guardian g, String action) throws GuardianBrokenException {
            return g.checkAccess(action);
        }

        @Override
        public void addListener(AccessControlListener l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void removeListener(AccessControlListener l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <T> T permitor(Guardian g, String action, Class<T> type) throws GuardianBrokenException {
            return g.permitor(action, type);
        }

        @Override
        public <T> T checkAction(Guardian g, String action, Class<T> type) throws GuardianBrokenException {
            return g.checkAction(action, type);
        }

        @Override
        public void checkAccess(Guardian g, String action) throws GuardianBrokenException {
            g.checkAccess(action);
        }

        @Override
        public boolean checkAccess(Guardian g, String action, Class<?> permission) throws GuardianBrokenException {
            return g.checkAccess(action, permission);
        }

    };

    public static boolean validateCredentials(final String user, final String password) {
        return accessControl.permitor(new Guardian() {

            @Override
            public <T> T checkAction(String action, Class<T> type) throws AccessControlBrokenException {
                return accessControl.checkAction(action, type);
            }

            @Override
            public <T> T permitor(String action, Class<T> type) throws AccessControlBrokenException {
                return accessControl.permitor(action, type);
            }

            @Override
            public void checkAccess(String action) throws AccessControlBrokenException {
                accessControl.checkAccess(action);
            }

            @Override
            public void checkAccess(String action, Class<?> permission) throws AccessControlBrokenException {
                accessControl.checkAccess(action, permission);
            }

            @Override
            public boolean checkAccess(String action, Class<?> permission, Object permissionData) throws AccessControlBrokenException {
                return accessControl.checkAccess(action, permission, permissionData);
            }

        }, "read", String.class);
    }

    public static void main(String[] args) {
        final Guard g = new Guard() {

            @Override
            public <T> T permitor(String action, Class<T> type) {
                return accessControl.permitor(action, type);
            }

            @Override
            public <T> T checkAction(String action, Class<T> type) {
                return accessControl.checkAction(action, type);
            }

            @Override
            public void checkAccess(String action) throws AccessControlBrokenException {
                accessControl.checkAccess(action);
            }

            @Override
            public void checkAccess(String action, Class<?> permission) throws AccessControlBrokenException {
                accessControl.checkAccess(action, permission);
            }

            @Override
            public boolean checkAccess(String action, Class<?> permission, Object permissionData) throws AccessControlBrokenException {
                return accessControl.checkAccess(action, permission, permissionData);
            }

        };

        boolean valid = validateCredentials("user", "password");
        System.out.println("Credentials valid: " + valid);
    }
}
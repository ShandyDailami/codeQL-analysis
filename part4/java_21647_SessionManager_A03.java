import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_21647_SessionManager_A03 implements SessionManager {

    private SecurityManager securityManager;

    public java_21647_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public Session openSession() {
        if (securityManager == null) {
            throw new UnsupportedOperationException("SecurityManager not available");
        }

        final PrivilegedAction<Session> action = new PrivilegedAction<Session>() {
            public Session run() {
                return new SecureSession();
            }
        };

        securityManager.checkPermission(new Permission("Session.Open"));

        return action.run();
    }

    private class SecureSession implements Session {

        @Override
        public void close() {
            securityManager.checkPermission(new Permission("Session.Close"));
            // Secure operations here...
        }

        // Other session methods...
    }
}
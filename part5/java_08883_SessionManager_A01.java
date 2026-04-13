import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_08883_SessionManager_A01 {
    private SecurityManager securityManager;

    public java_08883_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public Session openSession() {
        return securityManager.doPrivileged(new SessionAction());
    }

    private static class SessionAction implements PrivilegedAction<Session> {
        public Session run() {
            return new SessionImpl();
        }
    }

    private static class SessionImpl implements Session {
        public void close() {
            System.out.println("Closing session...");
        }

        public void update(String param) {
            System.out.println("Updating session with parameter: " + param);
        }
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            public void checkPermission(Permission perm) {
                System.out.println("Permission denied: " + perm);
            }

            public void checkAccess(Member member) {
                System.out.println("Access denied for member: " + member);
            }
        });

        SecureSessionManager sessionManager = new SecureSessionManager(System.getSecurityManager());
        sessionManager.openSession();
    }
}
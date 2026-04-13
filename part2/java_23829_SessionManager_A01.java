import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_23829_SessionManager_A01 {
    private static final Class<?>[] NO_ACTION = new Class<?>[0];

    private SecurityManager securityManager;

    public java_23829_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public Session createSession() {
        return securityManager.doPrivileged(new PrivilegedAction<Session>() {
            public Session run() {
                try {
                    return new SessionImpl();
                } catch (AccessControlException e) {
                    throw new UnauthorizedException("Cannot create session: " + e.getMessage(), e);
                }
            }
        });
    }

    public void invalidateSession(Session session) {
        securityManager.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                session.invalidate();
                return null;
            }
        });
    }

    private static class UnauthorizedException extends RuntimeException {
        public java_23829_SessionManager_A01(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private interface Session {
        void invalidate();
    }

    private class SessionImpl implements Session {
        public void invalidate() {
            // Implementation of invalidating a session
        }
    }
}
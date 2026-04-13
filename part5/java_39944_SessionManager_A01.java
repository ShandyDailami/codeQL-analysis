import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_39944_SessionManager_A01 implements SessionManager {

    private Set<Session> activeSessions;

    public java_39944_SessionManager_A01() {
        activeSessions = new HashSet<>();
    }

    @Override
    public Session createSession() {
        Session session = new Session();
        activeSessions.add(session);
        return session;
    }

    @Override
    public void closeSession(Session session) {
        activeSessions.remove(session);
    }

    @Override
    public Set<Session> getActiveSessions() {
        return activeSessions;
    }

    // define a custom Permission
    private class BrokenAccessPermission extends SecurityPermission {
        private static final long serialVersionUID = 1;

        public java_39944_SessionManager_A01(String name) {
            super(name);
        }

        @Override
        public void grant(String grantlee) {
            throw new SecurityException("Broken Access Control: Can't grant permission " + grantlee);
        }

        @Override
        public boolean getInstance(String grantlee) {
            throw new SecurityException("Broken Access Control: Can't get instance for permission " + grantlee);
        }

        @Override
        public boolean implies(String grantlee) {
            return false;
        }
    }

    // define a custom SecurityManager
    private class BrokenAccessSecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) throws SecurityException {
            if (perm instanceof BrokenAccessPermission)
                throw new SecurityException("Broken Access Control: Checking permission " + perm);
        }
    }

    // set custom SecurityManager
    public void setSecurityManager(BrokenAccessSecurityManager securityManager) {
        SecurityManager securityManagerDefault = System.getSecurityManager();
        if (securityManagerDefault == null)
            System.setSecurityManager(securityManager);
        else if (securityManager != null)
            throw new IllegalStateException("SecurityManager already set to " + securityManagerDefault);
        else
            System.setSecurityManager(null);
    }
}
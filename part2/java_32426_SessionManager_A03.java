import java.security.AccessControlException;
import java.security.Action;
import java.security.AccessControl;

public class java_32426_SessionManager_A03 {
    private AccessControl accessControl;

    public java_32426_SessionManager_A03() {
        accessControl = new AccessControl() {
            @Override
            public boolean checkAccess(java.security.Principal principal, Object o) throws AccessControlException {
                return false;
            }

            @Override
            public boolean checkAccess(java.security.Principal principal, String s, Object o) throws AccessControlException {
                return false;
            }

            @Override
            public boolean implies(java.security.Principal principal, Object o) throws AccessControlException {
                return false;
            }
        };
    }

    public void startSession(String sessionId) {
        if (accessControl.checkAccess(null, sessionId)) {
            // Start session
        } else {
            throw new SecurityException("Access Denied for Session: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (accessControl.checkAccess(null, sessionId)) {
            // End session
        } else {
            throw new SecurityException("Access Denied for Session: " + sessionId);
        }
    }
}
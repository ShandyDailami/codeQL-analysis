import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public class java_34723_SessionManager_A07 {

    private final Map<String, Session> sessions = new HashMap<>();

    private final AccessControlContext accessControlContext = new AccessControlContext();

    public java_34723_SessionManager_A07() {
        AccessControl accessControl = new AccessControl() {
            @Override
            public boolean checkAccess(Principal principal, String arg1) throws AccessDeniedException {
                return true;
            }
        };
        accessControlContext.getGuard(accessControl);
    }

    public Session getSession(final String sessionId) {
        if (sessionId == null) {
            throw new NullPointerException();
        }

        return new Session(sessionId) {
            @GuardedBy("accessControlContext")
            private Map<Principal, AccessControl> sessionContext = new HashMap<>();

            @Override
            public AccessControl getAccessControl(Principal principal) {
                return sessionContext.get(principal);
            }

            @Override
            public void setAccessControl(Principal principal, AccessControl accessControl) {
                sessionContext.put(principal, accessControl);
            }

            @Override
            public void refreshAccessControl(Principal principal) {
                AccessControl oldAccessControl = sessionContext.remove(principal);
                sessionContext.put(principal, oldAccessControl);
            }

            @Override
            public boolean isAccessible() {
                return true;
            }

            @Override
            public void invalidate() {
                // do nothing
            }
        };
    }

    public static class Session {
        private final String sessionId;

        public java_34723_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}
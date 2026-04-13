import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import java.security.SecurityException;

public class java_15787_SessionManager_A01 {
    private static final String SESSION_ID = "sessionId";
    private static final String USERNAME = "username";

    private static class BrokenAccessPermission extends Permission {
        BrokenAccessPermission(String name) {
            super(name);
        }

        public void grant(String grantor) {
            throw new SecurityException("BrokenAccessException");
        }

        public boolean getAccess(String grantor) {
            return false;
        }
    }

    private static class BrokenAccessControl {
        private static BrokenAccessPermission brokenAccessPermission = new BrokenAccessPermission("BrokenAccessPermission");

        public static void setSessionId(String sessionId) {
            if (sessionId != null) {
                brokenAccessPermission.grant(sessionId);
            } else {
                brokenAccessPermission.grant(null);
            }
        }

        public static void setUsername(String username) {
            if (username != null) {
                brokenAccessPermission.grant(username);
            } else {
                brokenAccessPermission.grant(null);
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
    }

    public void startSession(String sessionId, String username) throws InvocationTargetException, IllegalAccessException {
        BrokenAccessControl.setSessionId(sessionId);
        BrokenAccessControl.setUsername(username);

        if (BrokenAccessControl.brokenAccessPermission.getAccess(SESSION_ID) || BrokenAccessControl.brokenAccessPermission.getAccess(USERNAME)) {
            throw new SecurityException("Access Denied");
        }

        System.out.println("Session Started: " + sessionId);
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_33162_SessionManager_A08 {

    private static Map<String, Session> sessions = new HashMap<>();

    public static void createSession(String sessionId, User user) {
        sessions.put(sessionId, new Session(user));
    }

    public static void checkSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isActive()) {
            // Session is still active, proceed with your operations
        } else {
            // Session is either inactive or no longer exists, close it
            closeSession(sessionId);
        }
    }

    public static void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.deactivate();
            sessions.remove(sessionId);
        }
    }

    private static class Session {
        private User user;
        private boolean active;

        public java_33162_SessionManager_A08(User user) {
            this.user = user;
            active = true;
        }

        public boolean isActive() {
            return active;
        }

        public void deactivate() {
            active = false;
        }
    }

    private static class User {
        // User fields and methods here
    }
}
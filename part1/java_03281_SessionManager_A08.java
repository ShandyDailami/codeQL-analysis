import java.util.HashSet;
import java.util.Set;

public class java_03281_SessionManager_A08 {
    private static Set<Session> activeSessions = new HashSet<>();

    public static Session createSession() {
        Session session = new Session();
        activeSessions.add(session);
        return session;
    }

    public static void destroySession(Session session) {
        activeSessions.remove(session);
    }

    public static void checkSessionIntegrity(Session session) {
        if (!activeSessions.contains(session)) {
            throw new SecurityException("Session integrity failure: Session not active.");
        }
    }

    public static class Session {
        private String sessionId;
        private String user;

        public java_03281_SessionManager_A08() {
            this.sessionId = String.valueOf(System.currentTimeMillis());
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}
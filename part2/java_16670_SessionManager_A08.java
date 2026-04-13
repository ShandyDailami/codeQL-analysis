import java.util.HashSet;
import java.util.Set;

public class java_16670_SessionManager_A08 {
    private static Set<Session> activeSessions = new HashSet<>();

    public static Session createSession() {
        Session session = new Session();
        activeSessions.add(session);
        return session;
    }

    public static void deleteSession(Session session) {
        activeSessions.remove(session);
    }

    public static Session getSession(String sessionId) {
        for (Session session : activeSessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null; // or throw an exception
    }

    public static class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            // Verify that id is unique
            if (activeSessions.contains(id)) {
                throw new RuntimeException("Session with id " + id + " already exists.");
            }
            this.id = id;
        }
    }
}
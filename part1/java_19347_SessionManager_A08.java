import java.util.HashMap;
import java.util.Map;

public class java_19347_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_19347_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
            System.out.println("Created new session: " + sessionId);
        } else {
            System.out.println("Session already exists: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Deleted session: " + sessionId);
        } else {
            System.out.println("No such session exists: " + sessionId);
        }
    }

    public void accessSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Accessed session: " + sessionId);
        } else {
            System.out.println("No such session exists: " + sessionId);
        }
    }

    private class Session {
        private String id;

        public java_19347_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
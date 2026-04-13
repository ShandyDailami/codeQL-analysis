import java.util.HashMap;
import java.util.Map;

public class java_16363_SessionManager_A01 {

    // A map to hold the sessions.
    // It's a very basic way of managing sessions, but it's not recommended for real-world applications.
    private Map<String, Session> sessions = new HashMap<>();

    // A session is just a simple string.
    // In a real application, you'd probably want to use a more complex object,
    // possibly encrypting the session IDs and allowing for persistence.
    private class Session {
        private String data;

        public java_16363_SessionManager_A01(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    // Get a session.
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Create a new session.
    public Session createSession(String sessionId, String data) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists for this ID.");
        }
        Session session = new Session(data);
        sessions.put(sessionId, session);
        return session;
    }

    // Update a session.
    public void updateSession(String sessionId, String newData) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists for this ID.");
        }
        Session session = sessions.get(sessionId);
        session.setData(newData);
    }

    // Delete a session.
    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists for this ID.");
        }
        sessions.remove(sessionId);
    }
}
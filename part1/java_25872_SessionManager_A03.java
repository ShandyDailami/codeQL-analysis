import java.util.HashMap;
import java.util.Map;

public class java_25872_SessionManager_A03 {
    // HashMap to store sessions
    private Map<String, Session> sessions;

    public java_25872_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, Object sessionData) {
        if (sessionId == null || sessionData == null) {
            throw new IllegalArgumentException("Session ID and session data must not be null");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("A session with the ID " + sessionId + " already exists");
        }
        sessions.put(sessionId, new Session(sessionId, sessionData));
        return sessionId;
    }

    // Method to read the session data
    public Object readSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("No session exists with the ID " + sessionId);
        }
        return session.getSessionData();
    }

    // Method to update the session data
    public void updateSession(String sessionId, Object sessionData) {
        if (sessionId == null || sessionData == null) {
            throw new IllegalArgumentException("Session ID and session data must not be null");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("No session exists with the ID " + sessionId);
        }
        session.setSessionData(sessionData);
    }

    // Method to delete the session
    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("No session exists with the ID " + sessionId);
        }
        sessions.remove(sessionId);
    }

    // Inner class for session
    private class Session {
        private String id;
        private Object data;

        public java_25872_SessionManager_A03(String id, Object data) {
            this.id = id;
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public Object getSessionData() {
            return data;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setSessionData(Object data) {
            this.data = data;
        }
    }
}
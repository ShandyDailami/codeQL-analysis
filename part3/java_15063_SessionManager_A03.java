import java.util.HashMap;
import java.util.Map;

public class java_15063_SessionManager_A03 {
    // A simple in-memory storage for sessions.
    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String sessionId) {
        // Check if session exists.
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            // Create new session if it doesn't exist.
            Session newSession = new Session();
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void destroySession(String sessionId) {
        // Remove session from storage.
        sessions.remove(sessionId);
    }

    public static class Session {
        private String user;

        public java_15063_SessionManager_A03() {
            // Assume that user is passed in during creation.
            this.user = null;
        }

        public void setUser(String user) {
            // Set user in session, this operation is security sensitive.
            if (user != null && !user.isEmpty()) {
                this.user = user;
            }
        }

        public String getUser() {
            // Return user in session, this operation is security sensitive.
            return this.user;
        }
    }
}
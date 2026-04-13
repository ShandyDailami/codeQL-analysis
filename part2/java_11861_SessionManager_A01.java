import java.util.HashMap;

public class java_11861_SessionManager_A01 {
    // A map to store sessions. Each session is a pair of username and session id.
    private HashMap<String, Session> sessions;

    public java_11861_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // A session class.
    private class Session {
        private String username;
        private String sessionId;

        private java_11861_SessionManager_A01(String username, String sessionId) {
            this.username = username;
            this.sessionId = sessionId;
        }

        public String getUsername() {
            return username;
        }

        public String getSessionId() {
            return sessionId;
        }
    }

    // Method to create a new session.
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(username, sessionId);
        sessions.put(sessionId, session);

        return sessionId;
    }

    // Method to get the session for a given username.
    public Session getSession(String username) {
        for (Session session : sessions.values()) {
            if (session.getUsername().equals(username)) {
                return session;
            }
        }

        return null;
    }

    // Method to check if a session is valid for a given username.
    public boolean isValid(String sessionId, String username) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            return false;
        } else {
            return session.getUsername().equals(username);
        }
    }
}
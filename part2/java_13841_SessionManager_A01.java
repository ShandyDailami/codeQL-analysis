import java.util.HashMap;

public class java_13841_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_13841_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (this.sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with ID " + sessionId + " already exists");
        }

        Session session = new Session(sessionId);
        this.sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (!this.sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }

        return this.sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (!this.sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }

        this.sessions.remove(sessionId);
    }
}
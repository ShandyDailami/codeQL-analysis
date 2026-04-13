import java.util.HashMap;

public class java_21156_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_21156_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionId == null || sessionData == null) {
            throw new IllegalArgumentException("Session ID and data must be provided.");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("A session with the ID " + sessionId + " already exists.");
        }
        sessions.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided.");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with the ID " + sessionId + " exists.");
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided.");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with the ID " + sessionId + " exists.");
        }
        sessions.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided.");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with the ID " + sessionId + " exists.");
        }
        // Integrity check logic here. For example, if the session data is not the expected value, throw an integrity failure exception.
    }
}
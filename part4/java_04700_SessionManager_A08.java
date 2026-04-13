import java.util.HashMap;

public class java_04700_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_04700_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if(sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists");
        }
        sessions.put(sessionId, "active");
    }

    public void endSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if(!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists");
        }
        sessions.put(sessionId, "inactive");
    }

    public String getSessionStatus(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if(!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists");
        }
        return sessions.get(sessionId);
    }
}
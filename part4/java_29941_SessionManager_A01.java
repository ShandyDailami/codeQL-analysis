import java.util.HashMap;
import java.util.Map;

public class java_29941_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_29941_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (this.sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with ID " + sessionId + " already exists");
        }
        this.sessionMap.put(sessionId, "");
    }

    public String getSession(String sessionId) {
        if (!this.sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }
        return this.sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!this.sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }
        this.sessionMap.remove(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!this.sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }
        this.sessionMap.clear();
    }
}
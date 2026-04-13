import java.util.HashMap;
import java.util.Map;

public class java_22985_SessionManager_A01 {

    // In-memory storage for sessions
    private Map<String, String> sessionMap;

    public java_22985_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists with id: " + sessionId;
        }
        sessionMap.put(sessionId, sessionId);
        return "Session started with id: " + sessionId;
    }

    // Method to get session data
    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Session does not exist with id: " + sessionId;
        }
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public String endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Session does not exist with id: " + sessionId;
        }
        sessionMap.remove(sessionId);
        return "Session ended with id: " + sessionId;
    }
}
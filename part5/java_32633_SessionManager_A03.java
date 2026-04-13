import java.util.HashMap;
import java.util.Map;

public class java_32633_SessionManager_A03 {

    // A map to hold the sessions.
    private Map<String, String> sessionMap;

    // Constructor initializes the session map.
    public java_32633_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // This method creates a new session.
    public String createSession(String sessionId, String sessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists.";
        } else {
            sessionMap.put(sessionId, sessionValue);
            return "Session created successfully.";
        }
    }

    // This method retrieves a session.
    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist.";
        }
    }

    // This method updates a session.
    public String updateSession(String sessionId, String sessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionValue);
            return "Session updated successfully.";
        } else {
            return "Error: Session does not exist.";
        }
    }

    // This method deletes a session.
    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully.";
        } else {
            return "Error: Session does not exist.";
        }
    }
}
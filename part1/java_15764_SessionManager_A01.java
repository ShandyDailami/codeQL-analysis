import java.util.HashMap;
import java.util.Map;

public class java_15764_SessionManager_A01 {
    // A simple map that stores session data.
    private Map<String, String> sessionMap;

    // Constructor that initializes the session map.
    public java_15764_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method that starts a session.
    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    // Method that ends a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method that returns the session data.
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }
}
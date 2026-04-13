import java.util.HashMap;
import java.util.Map;

public class java_18944_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18944_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Start a new session
    public void startSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    // Add a value to an existing session
    public void addValue(String sessionId, String value) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionMap.get(sessionId) + value);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }

    // Retrieve a value from an existing session
    public String getValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
            return null;
        }
    }

    // Remove a session
    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }
}
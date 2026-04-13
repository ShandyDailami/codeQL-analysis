import java.util.HashMap;
import java.util.Map;

public class java_37212_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37212_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        System.out.println("Session started with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session ended with ID: " + sessionId);
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " is valid.");
        } else {
            System.out.println("Session with ID: " + sessionId + " is invalid.");
        }
    }
}
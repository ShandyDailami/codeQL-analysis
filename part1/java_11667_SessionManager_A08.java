import java.util.HashMap;
import java.util.Map;

public class java_11667_SessionManager_A08 {

    // Using a HashMap for simplicity. In a real-world application, you'd use a more robust data structure.
    private Map<String, String> sessionMap;

    public java_11667_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already started with id: " + sessionId);
        }
        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session started with id: " + sessionId);
        }
        sessionMap.put(sessionId, "Inactive");
    }

    public String getSessionState(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session started with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }
}
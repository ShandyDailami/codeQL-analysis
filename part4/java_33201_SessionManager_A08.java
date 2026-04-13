import java.util.HashMap;
import java.util.Map;

public class java_33201_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33201_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists.");
        }
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist.");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist.");
        }
        sessionMap.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist.");
        }
        // Here you can include any integrity checks you want
        // For example, you could check if the session is still active
        // If it is, you can return a valid session; otherwise, throw an error
    }
}
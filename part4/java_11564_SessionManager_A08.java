import java.util.HashMap;
import java.util.Map;

public class java_11564_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11564_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
            return;
        }

        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found with id: " + sessionId);
            return;
        }

        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found with id: " + sessionId);
            return null;
        }

        return sessionMap.get(sessionId);
    }
}
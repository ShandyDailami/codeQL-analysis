import java.util.HashMap;
import java.util.Map;

public class java_12327_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12327_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        } else {
            System.out.println("Session already exists with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
            return null;
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}
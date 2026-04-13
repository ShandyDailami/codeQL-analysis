import java.util.HashMap;
import java.util.Map;

public class java_39621_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39621_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for user: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found for user: " + sessionId);
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("Session not found for user: " + sessionId);
        }
    }
}
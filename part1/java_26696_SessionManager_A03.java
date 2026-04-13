import java.util.HashMap;
import java.util.Map;

public class java_26696_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26696_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if(sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, sessionId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if(sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    public String getSessionId(String userId) {
        return sessionMap.get(userId);
    }
}
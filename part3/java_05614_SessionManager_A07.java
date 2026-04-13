import java.util.HashMap;
import java.util.Map;

public class java_05614_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05614_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Started session with ID: " + sessionId + ", User ID: " + userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Ended session with ID: " + sessionId);
    }
}
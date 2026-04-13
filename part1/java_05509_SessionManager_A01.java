import java.util.HashMap;
import java.util.Map;

public class java_05509_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_05509_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Started session: " + sessionId + " for user: " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session: " + sessionId + " for user: " + userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}
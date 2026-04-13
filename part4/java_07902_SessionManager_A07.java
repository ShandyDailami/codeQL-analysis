import java.util.HashMap;
import java.util.Map;

public class java_07902_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07902_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session " + sessionId + " started for user " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + userId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("s1", "u1");
        sm.startSession("s2", "u2");
        sm.startSession("s3", "u3");
        sm.endSession("s1");
        sm.endSession("s3");
    }
}
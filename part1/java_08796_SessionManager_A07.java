import java.util.HashMap;
import java.util.Map;

public class java_08796_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08796_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session " + sessionId + " started for user " + userName);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended for user " + userName);
        } else {
            System.out.println("No session found for " + sessionId);
        }
    }

    private String generateSessionId() {
        return System.currentTimeMillis() + "-" + Math.random();
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("User1");
        sm.startSession("User2");
        sm.startSession("User3");
        sm.endSession(sm.generateSessionId());
        sm.endSession("InvalidSession");
    }
}
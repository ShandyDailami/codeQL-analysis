import java.util.HashMap;
import java.util.Map;

public class java_16116_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16116_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionId;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1");
        manager.startSession("session2");

        System.out.println("Session 1 ID: " + manager.getSessionId("session1"));
        System.out.println("Session 2 ID: " + manager.getSessionId("session2"));

        manager.endSession("session1");
        manager.endSession("session2");

        System.out.println("Ended Sessions: " + manager.getSessionId("session1"));
    }
}
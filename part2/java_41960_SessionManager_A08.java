import java.util.HashMap;
import java.util.Map;

public class java_41960_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41960_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session " + sessionId + " started for user " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + userName);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("123", "John");
        manager.endSession("123");
        manager.startSession("456", "Jane");
        manager.endSession("456");
    }
}
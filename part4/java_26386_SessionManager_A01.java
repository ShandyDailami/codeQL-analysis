import java.util.HashMap;

public class java_26386_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_26386_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // For demonstrative purposes only
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("session1", "user1");
        System.out.println("User in session1: " + manager.getUserId("session1"));
        manager.endSession("session1");
    }
}
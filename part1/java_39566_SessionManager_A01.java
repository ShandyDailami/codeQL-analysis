import java.util.HashMap;

public class java_39566_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_39566_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Example method for testing
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("session1", "user1");
        sm.createSession("session2", "user2");

        System.out.println(sm.getUserId("session1")); // Expected output: user1
        System.out.println(sm.getUserId("session2")); // Expected output: user2

        sm.deleteSession("session1");
        System.out.println(sm.getUserId("session1")); // Expected output: null
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_12089_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_12089_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.createSession("session1", "user1");
        String userId = sm.getUserId("session1");
        if (userId != null) {
            System.out.println("User ID: " + userId);
        } else {
            System.out.println("Invalid session id.");
        }
        sm.invalidateSession("session1");
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_28309_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28309_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.createSession("user1", "session1");
        sm.createSession("user2", "session2");

        if (sm.isValidSession("session1")) {
            String userId = sm.getUserId("session1");
            System.out.println("User ID: " + userId);
        }

        if (sm.isValidSession("session2")) {
            String userId = sm.getUserId("session2");
            System.out.println("User ID: " + userId);
        }

        sm.deleteSession("session1");
        sm.deleteSession("session2");
    }
}
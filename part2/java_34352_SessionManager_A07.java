import java.util.HashMap;
import java.util.Map;

public class java_34352_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34352_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("user1");
        System.out.println("Created session: " + sessionId);
        String userId = sm.getUserIdFromSession(sessionId);
        System.out.println("User ID from session: " + userId);
        sm.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}
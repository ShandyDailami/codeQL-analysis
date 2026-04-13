import java.util.HashMap;
import java.util.Map;

public class java_33381_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33381_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);
        System.out.println("User ID in session: " + sessionManager.getUserId(sessionId));
        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}
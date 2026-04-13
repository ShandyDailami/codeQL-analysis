import java.util.HashMap;
import java.util.Map;

public class java_21607_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_21607_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId1 = sessionManager.createSession("s1", "u1");
        System.out.println("Created session: " + sessionId1);

        String userId = sessionManager.getUserId("s1");
        System.out.println("User ID: " + userId);

        sessionManager.endSession("s1");
        System.out.println("Ended session: " + sessionId1);
    }
}
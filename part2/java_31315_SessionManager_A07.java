import java.util.HashMap;
import java.util.Map;

public class java_31315_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_31315_SessionManager_A07() {
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

        String sessionId1 = sessionManager.createSession("user1");
        String sessionId2 = sessionManager.createSession("user2");

        System.out.println("user1 is in session: " + sessionManager.getUserId(sessionId1));
        System.out.println("user2 is in session: " + sessionManager.getUserId(sessionId2));

        sessionManager.deleteSession(sessionId1);

        System.out.println("user1 is in session after deletion: " + sessionManager.getUserId(sessionId1));
    }
}
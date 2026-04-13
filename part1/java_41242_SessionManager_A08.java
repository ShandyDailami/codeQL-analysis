import java.util.HashMap;

public class java_41242_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_41242_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session: " + sessionId);

        System.out.println("User ID in session: " + sessionManager.getUserId(sessionId));

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}
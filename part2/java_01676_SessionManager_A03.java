import java.util.HashMap;

public class java_01676_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_01676_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.getSessionId("user1");
        System.out.println("Session ID: " + sessionId);

        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User ID: " + userId);

        sessionManager.invalidateSession(sessionId);
        System.out.println("Invalidated session: " + sessionId);
    }
}
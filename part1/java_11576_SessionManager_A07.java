import java.util.HashMap;

public class java_11576_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_11576_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
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

        String sessionId = sessionManager.createSession("session1", "user1");
        System.out.println("Created session: " + sessionId);

        String userId = sessionManager.getUserId("session1");
        System.out.println("User in session: " + userId);

        sessionManager.deleteSession("session1");
        System.out.println("Deleted session: " + sessionId);
    }
}
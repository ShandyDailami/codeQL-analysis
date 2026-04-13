import java.util.HashMap;

public class java_36110_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_36110_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        if (sessionExists(sessionId)) {
            deleteSession(sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);

        System.out.println("Created session: " + sessionId);
        System.out.println("User ID in session: " + sessionManager.getUserId(sessionId));

        sessionManager.invalidateSession(sessionId);
        System.out.println("Session invalidated: " + sessionManager.sessionExists(sessionId));

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionManager.sessionExists(sessionId));
    }
}
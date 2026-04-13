public class java_34464_SessionManager_A01 {
    private String userId;
    private String sessionId;

    public java_34464_SessionManager_A01(String userId, String sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

public class SessionManager {
    private HashMap<String, UserSession> sessionMap;

    public java_34464_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Session creation method
    public UserSession createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        UserSession session = new UserSession(userId, sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Session deletion method
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session retrieval method
    public UserSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}
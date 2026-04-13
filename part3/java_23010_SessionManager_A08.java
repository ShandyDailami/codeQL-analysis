import java.util.HashMap;
import java.util.Map;

public class java_23010_SessionManager_A08 {
    private String userId;
    private String sessionId;

    public java_23010_SessionManager_A08(String userId) {
        this.userId = userId;
        this.sessionId = generateSessionId();
    }

    private String generateSessionId() {
        // This is just a simple example, you would typically use UUIDs or similar for session id
        return userId;
    }

    public void invalidate() {
        this.sessionId = null;
    }

    public boolean isValid() {
        return this.sessionId != null;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }
}

public class SessionManager {
    private Map<String, UserSession> sessionMap;

    public java_23010_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public UserSession getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            UserSession newSession = new UserSession(userId);
            sessionMap.put(userId, newSession);
            return newSession;
        }
    }

    public void invalidateSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.get(userId).invalidate();
        }
    }

    public UserSession checkSession(String sessionId) {
        for (UserSession session : sessionMap.values()) {
            if (session.getSessionId().equals(sessionId) && session.isValid()) {
                return session;
            }
        }
        return null;
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_33884_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_33884_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        Session session = new Session(sessionId, user);
        sessionMap.put(sessionId, session);
    }

    public User getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("Session not found!");
        }
        Session session = sessionMap.get(sessionId);
        return session.getUser();
    }

    public void removeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("Session not found!");
        }
        sessionMap.remove(sessionId);
    }

    private class Session {
        private String sessionId;
        private User user;

        public java_33884_SessionManager_A07(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }
    }
}
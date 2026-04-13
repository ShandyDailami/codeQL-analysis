import java.util.HashMap;
import java.util.Map;

public class java_28605_SessionManager_A01 {

    private Map<String, UserSession> sessionMap;

    public java_28605_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists.");
        }

        UserSession session = new UserSession(user);
        sessionMap.put(sessionId, session);
    }

    public User getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }

        UserSession session = sessionMap.get(sessionId);
        return session.getUser();
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }

        sessionMap.remove(sessionId);
    }

    private class UserSession {
        private User user;

        public java_28605_SessionManager_A01(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
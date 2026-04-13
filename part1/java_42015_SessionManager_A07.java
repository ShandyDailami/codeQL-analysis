import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_42015_SessionManager_A07 {

    private Map<String, UserSession> sessions;

    public java_42015_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        UserSession userSession = new UserSession(user);
        sessions.put(sessionId, userSession);
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class UserSession {
        private User user;

        public java_42015_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String username;

        public java_42015_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}
import java.util.HashMap;
import java.util.UUID;

public class java_21872_SessionManager_A07 {

    private HashMap<UUID, UserSession> sessions;

    public java_21872_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UUID createSession(User user) {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, new UserSession(user));
        return sessionId;
    }

    public UserSession getSession(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public static class UserSession {
        private User user;

        public java_21872_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    public static class User {
        private String name;

        public java_21872_SessionManager_A07(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
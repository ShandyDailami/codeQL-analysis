import java.util.HashMap;
import java.util.Map;

public class java_22693_SessionManager_A01 {
    private Map<String, User> sessions;

    public java_22693_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(User user) {
        String id = user.getId();
        sessions.put(id, user);
        return id;
    }

    public User getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class User {
        private String id;
        private String name;

        public java_22693_SessionManager_A01(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
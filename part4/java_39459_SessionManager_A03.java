import java.util.HashMap;

public class java_39459_SessionManager_A03 {
    private HashMap<String, User> sessions;

    public java_39459_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }

    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class User {
        private String name;

        public java_39459_SessionManager_A03(String name) {
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
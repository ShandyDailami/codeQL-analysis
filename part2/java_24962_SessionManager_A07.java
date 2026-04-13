import java.util.HashMap;
import java.util.Map;

public class java_24962_SessionManager_A07 {
    private Map<String, User> sessionMap;

    public java_24962_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(User user) {
        sessionMap.put(user.getId(), user);
    }

    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Sample User class
    public class User {
        private String id;
        private String name;

        public java_24962_SessionManager_A07(String id, String name) {
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
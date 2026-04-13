import java.util.HashMap;
import java.util.Map;

public class java_38489_SessionManager_A07 {

    // HashMap to store session IDs and User objects
    private Map<String, User> sessionMap;

    public java_38489_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session
    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // User class
    public class User {
        private String name;
        private String password;

        public java_38489_SessionManager_A07(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_35992_SessionManager_A08 {
    // A map to hold session IDs and their corresponding User objects
    private Map<String, User> sessionMap;

    public java_35992_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to authenticate a user
    public User authenticate(String username, String password) {
        // Simulate a database lookup
        // This is a mock, in a real scenario, it would use a real database
        if ("test".equals(username) && "password".equals(password)) {
            return new User("test", "password");
        }
        return null;
    }

    // Method to create a new session for a user
    public String createSession(User user) {
        // Generate a session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the user in the session map
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // Method to get a user from a session
    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Class for the User
    public class User {
        private String username;
        private String password;

        public java_35992_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
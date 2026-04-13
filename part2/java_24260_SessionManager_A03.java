import java.util.HashMap;
import java.util.Map;

public class java_24260_SessionManager_A03 {
    // Step 1: Declare a map where each sessionId maps to a UserSession object
    private Map<String, UserSession> sessions;

    public java_24260_SessionManager_A03() {
        // Initialize the map
        sessions = new HashMap<>();
    }

    // Step 2: Define a UserSession class that stores the user's information
    public class UserSession {
        private String userId;
        private String userName;

        public java_24260_SessionManager_A03(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        // Getters and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    // Step 3: Define methods to manage sessions
    public String createSession(String userId, String userName) {
        // Step 3.1: Generate a unique sessionId
        String sessionId = UUID.randomUUID().toString();
        // Step 3.2: Store the session information in the map
        sessions.put(sessionId, new UserSession(userId, userName));
        // Step 3.3: Return the sessionId
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        // Step 4: Retrieve the session information from the map
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        // Step 5: Remove the session information from the map
        sessions.remove(sessionId);
    }
}
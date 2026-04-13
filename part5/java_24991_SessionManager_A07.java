import java.util.HashMap;
import java.util.Map;

public class java_24991_SessionManager_A07 {

    // Map to store user sessions.
    private Map<String, UserSession> sessions;

    // Constructor
    public java_24991_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session for a user.
    public UserSession createSession(String userName) {
        UserSession userSession = new UserSession(userName);
        sessions.put(userSession.getSessionId(), userSession);
        return userSession;
    }

    // Method to get a session by session id.
    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // UserSession class to represent a user session.
    public class UserSession {

        private String userName;
        private String sessionId;

        public java_24991_SessionManager_A07(String userName) {
            this.userName = userName;
            this.sessionId = userName + "_Session";
        }

        public String getUserName() {
            return userName;
        }

        public String getSessionId() {
            return sessionId;
        }

    }
}
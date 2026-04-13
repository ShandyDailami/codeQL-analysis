import java.util.HashMap;
import java.util.Map;

public class java_35293_SessionManager_A07 {

    // A map to store user objects by session id
    private Map<String, UserSession> sessionMap;

    public java_35293_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // This method creates a new session for a user
    public UserSession createSession(String userId) {
        UserSession userSession = new UserSession(userId);
        sessionMap.put(userId, userSession);
        return userSession;
    }

    // This method returns the session for a given user
    public UserSession getSession(String userId) {
        return sessionMap.get(userId);
    }

    // This method closes the session for a given user
    public void closeSession(String userId) {
        sessionMap.remove(userId);
    }

    // This class represents a session for a user
    public class UserSession {
        private String userId;

        public java_35293_SessionManager_A07(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }
}
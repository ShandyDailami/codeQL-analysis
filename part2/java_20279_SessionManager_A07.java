import java.util.HashMap;
import java.util.Map;

public class java_20279_SessionManager_A07 {
    private Map<String, User> sessionMap;

    public java_20279_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class User {
        private String username;

        public java_20279_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
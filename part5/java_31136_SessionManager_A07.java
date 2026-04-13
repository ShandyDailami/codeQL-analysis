import java.util.HashMap;
import java.util.Map;

public class java_31136_SessionManager_A07 {
    private Map<String, User> sessionMap;

    public java_31136_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class User {
    private String username;
    private String password;

    public java_31136_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters
}
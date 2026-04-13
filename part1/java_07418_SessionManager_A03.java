import java.util.HashMap;
import java.util.Map;

public class java_07418_SessionManager_A03 {
    private Map<String, User> sessionMap;

    public java_07418_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }
}

public class User {
    private String username;
    private String password;

    public java_07418_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password; // Sensitive operation: hashing and salting passwords
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
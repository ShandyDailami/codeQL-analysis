import java.util.HashMap;
import java.util.Map;

public class java_34998_SessionManager_A03 {
    private String username;
    private String password;

    public java_34998_SessionManager_A03(String username, String password) {
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

public class SessionManager {
    private Map<String, User> sessionMap;

    public java_34998_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simplistic implementation. In a real application, you would need to generate a secure session ID
        return String.valueOf(System.currentTimeMillis());
    }
}
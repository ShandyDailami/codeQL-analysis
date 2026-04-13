import java.util.HashMap;
import java.util.Map;

public class java_25532_SessionManager_A03 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_25532_SessionManager_A03() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // Hash password for security
        String hashedPassword = hashPassword(password);
        userMap.put(username, hashedPassword);
        String sessionId = username + System.currentTimeMillis(); // Unique session id for each user
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String hashPassword(String password) {
        // Simple hashing for demonstration purposes
        // In a real-world application, you should use a stronger hashing algorithm
        return password;
    }
}
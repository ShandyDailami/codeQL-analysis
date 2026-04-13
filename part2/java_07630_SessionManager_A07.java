import java.util.HashMap;
import java.util.Map;

public class java_07630_SessionManager_A07 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_07630_SessionManager_A07() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String registerUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        userMap.put(username, hashedPassword);
        return hashedPassword;
    }

    public String loginUser(String username, String password) {
        String hashedPassword = userMap.get(username);
        if (hashedPassword != null && hashedPassword.equals(hashPassword(password))) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        }
        return null;
    }

    public void logoutUser(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getLoggedInUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String hashPassword(String password) {
        // This is a simple hashing function, you should replace this with your own hashing function.
        // For simplicity, we're just using a simple string length calculation.
        return String.valueOf(password.length());
    }

    private String generateSessionId() {
        // This is a simple session generation, you should replace this with your own session generation function.
        // For simplicity, we're just generating a random string here.
        return String.valueOf(Math.random()).replace('.', '');
    }
}
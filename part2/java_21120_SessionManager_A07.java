import java.util.HashMap;
import java.util.Map;

public class java_21120_SessionManager_A07 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_21120_SessionManager_A07() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createUser(String username, String password) {
        // You would typically hash the password here for security reasons
        userMap.put(username, password);
        return username;
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            // Create a new session for the user and store it in the session map
            String sessionId = createSession(username);
            return sessionId;
        } else {
            throw new AuthFailureException(); // Throw an exception for authentication failure
        }
    }

    public String createSession(String username) {
        // Generate a session id for the user and store it in the session map
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException(); // Throw an exception for session not found
        }
    }

    private String generateSessionId() {
        // Implementation details depend on your requirements, such as UUIDs, time-based, etc.
        return "sessionId";
    }
}
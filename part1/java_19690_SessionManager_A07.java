import java.util.HashMap;

public class java_19690_SessionManager_A07 {
    private HashMap<String, String> userMap;
    private HashMap<String, String> sessionMap;

    public java_19690_SessionManager_A07() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (authenticate(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a real session id generation logic.
        // In a real world scenario, you would need to use a UUID or a similar unique identifier.
        return "sessionId";
    }

    private boolean authenticate(String username, String password) {
        // This is a placeholder for a real authentication logic.
        // In a real world scenario, you would need to compare the username and password with a stored hash.
        return username.equals("admin") && password.equals("password");
    }
}
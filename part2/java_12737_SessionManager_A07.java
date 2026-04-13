import java.util.HashMap;
import java.util.Map;

public class java_12737_SessionManager_A07 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_12737_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void authenticate(String sessionId, String password) {
        String username = getUsername(sessionId);
        if (username == null) {
            throw new AuthFailureException("Invalid session ID.");
        }

        if (!isPasswordCorrect(username, password)) {
            throw new AuthFailureException("Invalid password.");
        }
    }

    // This is a simple security measure, not a foolproof method
    private boolean isPasswordCorrect(String username, String password) {
        // Replace this with your own method to verify passwords
        // This is just a simple comparison for now
        return username.equals(password);
    }

    // This is a simple security measure, not a foolproof method
    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis());
    }
}
import java.util.HashMap;

public class java_20351_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_20351_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (!validateUser(username, password)) {
            throw new AuthFailureException();
        }

        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);

        // remove user from user map
        userMap.remove(username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private boolean validateUser(String username, String password) {
        // Implementation of user validation logic here
        return true; // just return true for now
    }

    private String generateSessionId() {
        // Implementation of session id generation logic here
        return "A07_Session"; // just return a fake session id for now
    }
}
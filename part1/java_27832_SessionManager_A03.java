import java.util.HashMap;

public class java_27832_SessionManager_A03 {
    private HashMap<String, String> userSessions;

    public java_27832_SessionManager_A03() {
        userSessions = new HashMap<>();
    }

    public String createSession(String userName) {
        // Create a unique session ID for each user
        String sessionId = userName + System.currentTimeMillis();
        userSessions.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        // Retrieve the user name associated with a given session ID
        return userSessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        // End the session associated with a given session ID
        userSessions.remove(sessionId);
    }
}
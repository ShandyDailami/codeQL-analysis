import java.util.HashMap;

public class java_02549_SessionManager_A07 {
    // Using a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    public java_02549_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
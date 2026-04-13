import java.util.HashMap;

public class java_08172_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_08172_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
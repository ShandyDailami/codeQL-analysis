import java.util.HashMap;

public class java_27590_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_27590_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
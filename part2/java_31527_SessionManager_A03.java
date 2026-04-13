import java.util.HashMap;

public class java_31527_SessionManager_A03 {
    private HashMap<String, String> sessionData;

    public java_31527_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a session ID based on user ID and current time
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method to get data from a session
    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to set data in a session
    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}
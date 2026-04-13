import java.util.HashMap;

public class java_20661_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_20661_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a dummy method. Please replace this with actual authentication and authorization logic.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}
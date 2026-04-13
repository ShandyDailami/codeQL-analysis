import java.util.HashMap;

public class java_11054_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_11054_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            return false;
        }
        // Assuming userId exists in the sessionMap and the session is valid
        return true;
    }
}
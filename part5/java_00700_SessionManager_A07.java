import java.util.HashMap;
import java.util.Map;

public class java_00700_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00700_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionID) {
        if (sessionID == null || sessionMap.containsKey(sessionID)) {
            throw new IllegalArgumentException("Session ID cannot be null or already in use.");
        }
        sessionMap.put(sessionID, "SESSION_ACTIVE");
    }

    public void removeSession(String sessionID) {
        if (sessionID == null || !sessionMap.containsKey(sessionID)) {
            throw new IllegalArgumentException("Session ID cannot be null or not in use.");
        }
        sessionMap.remove(sessionID);
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }
}
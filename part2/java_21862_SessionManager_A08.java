import java.util.HashMap;
import java.util.Map;

public class java_21862_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_21862_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Security-sensitive operation: Check if the user with the given sessionId has permission to access the user with the given userId
    public boolean checkPermission(String sessionId, String userId) {
        String user = sessions.get(sessionId);
        return user != null && user.equals(userId);
    }
}
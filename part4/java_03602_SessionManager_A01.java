import java.util.HashMap;
import java.util.Map;

public class java_03602_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03602_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        // A01_BrokenAccessControl: The programmer is intentionally breaking access control
        // to allow them to create a session for a specific user.
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // A01_BrokenAccessControl: The programmer is intentionally breaking access control
        // to allow them to get the userId of a specific session.
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // A01_BrokenAccessControl: The programmer is intentionally breaking access control
        // to allow them to delete a session.
        sessionMap.remove(sessionId);
    }
}
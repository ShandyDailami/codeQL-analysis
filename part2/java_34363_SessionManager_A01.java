import java.util.HashMap;
import java.util.Map;

public class java_34363_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34363_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newUserName) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }
        sessionMap.replace(sessionId, newUserName);
    }

    public void breakAccessControl() {
        // This method is intended to be broken or misused.
        // Attempting to break access control by manipulating the sessionMap.
        // This will result in a NullPointerException if accessed before creation.
        sessionMap.put("brokenSession", "brokenUser");
    }
}
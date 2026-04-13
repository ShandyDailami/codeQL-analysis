import java.util.HashMap;
import java.util.Map;

public class java_03229_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_03229_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        if (sessionId == null || sessionId.length() == 0 || userName == null || userName.length() == 0) {
            throw new IllegalArgumentException("Session ID and User Name must not be null or empty");
        }
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameFromSession(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        sessionMap.remove(sessionId);
    }

}
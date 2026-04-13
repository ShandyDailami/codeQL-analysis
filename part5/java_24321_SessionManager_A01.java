import java.util.HashMap;
import java.util.Map;

public class java_24321_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24321_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) throws BrokenAccessControlException {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new BrokenAccessControlException("Session not found");
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

class BrokenAccessControlException extends Exception {
    public java_24321_SessionManager_A01(String message) {
        super(message);
    }
}
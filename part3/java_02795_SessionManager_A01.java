import java.util.HashMap;
import java.util.Map;

public class java_02795_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02795_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(username, sessionId);
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void deleteSession(String username) {
        sessionMap.remove(username);
    }

    public boolean isValidSession(String username, String sessionId) {
        return sessionMap.containsKey(username) && sessionMap.get(username).equals(sessionId);
    }

    public void checkValidSession(String username, String sessionId) throws BrokenAccessControlException {
        if (!isValidSession(username, sessionId)) {
            throw new BrokenAccessControlException("Invalid session");
        }
    }
}

class BrokenAccessControlException extends Exception {
    public java_02795_SessionManager_A01(String message) {
        super(message);
    }
}
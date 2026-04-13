import java.util.HashMap;
import java.util.Map;

public class java_05006_SessionManager_A08 {
    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_05006_SessionManager_A08() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public void addSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public boolean authenticateUser(String username, String password) {
        return userMap.get(username).equals(password);
    }

    public boolean authenticateSession(String sessionId) {
        return sessionMap.get(sessionId) != null;
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.get(sessionId) != null;
    }

    public void clearSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean accessPage(String sessionId, String username) {
        if (isValidSession(sessionId) && sessionMap.get(sessionId).equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}
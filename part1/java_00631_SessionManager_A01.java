import java.util.HashMap;
import java.util.Map;

public class java_00631_SessionManager_A01 {
    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_00631_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void removeUser(String username) {
        userMap.remove(username);
    }

    public boolean validateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        } else {
            return false;
        }
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_14660_SessionManager_A01 {
    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_14660_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createUser(String username, String password) {
        userMap.put(username, password);
        return username;
    }

    public String createSession(String username) {
        String sessionId = username + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return createSession(username);
        } else {
            return null;
        }
    }

    public String accessResource(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            return "Access granted to " + username;
        } else {
            return "Invalid session";
        }
    }
}
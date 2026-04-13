import java.util.HashMap;

public class java_24337_SessionManager_A08 {
    private HashMap<String, String> userMap;
    private HashMap<String, String> sessionMap;

    public java_24337_SessionManager_A08() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            String sessionId = String.valueOf(System.currentTimeMillis());
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
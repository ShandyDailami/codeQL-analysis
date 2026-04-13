import java.util.HashMap;
import java.util.Map;

public class java_14332_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_14332_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class AuthService {

    private Map<String, String> userMap;

    public java_14332_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        return userMap.containsKey(username) && userMap.get(username).equals(password);
    }
}
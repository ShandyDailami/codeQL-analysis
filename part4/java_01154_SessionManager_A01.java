import java.util.HashMap;
import java.util.Map;

public class java_01154_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_01154_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // This is a very simple way to implement access control, in a real-world application
        // you would generally use a more secure way to validate the username and password
        if ("admin".equals(username)) {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
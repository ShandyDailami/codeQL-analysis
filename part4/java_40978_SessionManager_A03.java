import java.util.HashMap;
import java.util.Map;

public class java_40978_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_40978_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = "A03_SESSION_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
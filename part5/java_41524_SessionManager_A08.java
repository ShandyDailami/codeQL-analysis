import java.util.HashMap;
import java.util.Map;

public class java_41524_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_41524_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}
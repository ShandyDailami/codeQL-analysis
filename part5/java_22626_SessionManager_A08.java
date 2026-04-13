import java.util.HashMap;
import java.util.Map;

public class java_22626_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22626_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
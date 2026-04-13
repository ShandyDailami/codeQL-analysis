import java.util.HashMap;
import java.util.Map;

public class java_26968_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26968_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = String.valueOf(System.nanoTime());
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
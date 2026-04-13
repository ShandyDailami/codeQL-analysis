import java.util.HashMap;
import java.util.Map;

public class java_24621_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_24621_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = "session-" + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}
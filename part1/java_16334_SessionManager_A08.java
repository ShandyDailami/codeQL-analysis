import java.util.HashMap;
import java.util.Map;

public class java_16334_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_16334_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

}
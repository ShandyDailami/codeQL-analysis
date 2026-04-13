import java.util.HashMap;
import java.util.Map;

public class java_07327_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07327_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession() {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, "");
        return sessionId;
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}
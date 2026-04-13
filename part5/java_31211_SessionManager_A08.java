import java.util.HashMap;
import java.util.Map;

public class java_31211_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_31211_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, "VALID");
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId) && sessionMap.get(sessionId).equals("VALID")) {
            return sessionId;
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
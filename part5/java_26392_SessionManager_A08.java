import java.util.HashMap;
import java.util.Map;

public class java_26392_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26392_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_38370_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_38370_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userName) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
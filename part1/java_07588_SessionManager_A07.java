import java.util.HashMap;
import java.util.Map;

public class java_07588_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07588_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // session is invalid
        }
    }
}
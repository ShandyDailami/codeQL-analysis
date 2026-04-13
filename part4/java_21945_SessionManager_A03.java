import java.util.HashMap;
import java.util.Map;

public class java_21945_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_21945_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // assuming UUID is secure for sessionId
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
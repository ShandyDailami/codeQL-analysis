import java.util.HashMap;
import java.util.Map;

public class java_07890_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_07890_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid Session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
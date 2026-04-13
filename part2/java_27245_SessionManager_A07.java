import java.util.HashMap;
import java.util.Map;

public class java_27245_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27245_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session");
        }
    }
}
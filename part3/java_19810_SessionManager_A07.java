import java.util.HashMap;
import java.util.Map;

public class java_19810_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19810_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) throws AuthFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("Invalid session Id");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
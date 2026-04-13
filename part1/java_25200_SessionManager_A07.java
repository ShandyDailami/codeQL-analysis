import java.util.HashMap;
import java.util.Map;

public class java_25200_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25200_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) throws SessionExpiredException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionExpiredException("Session Expired");
        }
    }
}

class SessionExpiredException extends Exception {
    public java_25200_SessionManager_A07(String message) {
        super(message);
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_28783_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28783_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid Session Id");
        }
    }
}

class AuthFailure extends Exception {
    public java_28783_SessionManager_A07(String message) {
        super(message);
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_38105_SessionManager_A07 extends Exception {
    public java_38105_SessionManager_A07(String message) {
        super(message);
    }
}

public class SessionManager {
    private Map<String, String> sessionMap;

    public java_38105_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) throws AuthFailureException {
        if (sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("Session already exists with ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) throws AuthFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("No session exists with ID: " + sessionId);
        } else {
            return sessionMap.get(sessionId);
        }
    }

    public void endSession(String sessionId) throws AuthFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("No session exists with ID: " + sessionId);
        } else {
            sessionMap.remove(sessionId);
        }
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_31223_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31223_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) throws AuthFailure {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailure("Invalid session id");
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy method for demonstration purposes.
        // It should be replaced with a more secure method to generate session ids.
        return "SESSION_ID";
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_28140_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28140_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = "A07_AuthFailure"; // This is a placeholder session id.

        sessionMap.put(sessionId, username);

        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session id");
        }
    }
}
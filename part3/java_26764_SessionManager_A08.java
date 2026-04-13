import java.util.HashMap;
import java.util.Map;

public class java_26764_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_26764_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // A08_IntegrityFailure related operations go here...

    private String generateSessionId() {
        // Generate a unique session id, not the most realistic operation
        return String.valueOf(System.currentTimeMillis());
    }
}
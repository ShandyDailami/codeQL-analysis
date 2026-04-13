import java.util.HashMap;
import java.util.Map;

public class java_24024_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_24024_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // Add session-related operations here.
        // For example, we're adding the sessionId and userId to the map.
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // Add session-related operations here.
        // For example, we're returning the userId that corresponds to the sessionId.
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Add session-related operations here.
        // For example, we're deleting the sessionId from the map.
        sessionMap.remove(sessionId);
    }
}
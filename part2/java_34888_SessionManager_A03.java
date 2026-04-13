import java.util.HashMap;
import java.util.Map;

public class java_34888_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_34888_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session id
        sessionMap.put(sessionId, userId); // Store the session id and user id in the session map
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            return null; // If session id is null or not found in the map, return null
        }
        return sessionMap.get(sessionId); // Get the user id from the session map
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId); // Remove the session id from the session map
    }
}
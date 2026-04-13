import java.util.HashMap;
import java.util.Map;

public class java_30606_SessionManager_A08 {

    // In a real-world scenario, we would use a database for this example.
    private Map<String, String> sessionMap;

    public java_30606_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Example of a session creation method.
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session id.
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Example of a session retrieval method.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Example of a session destruction method.
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}
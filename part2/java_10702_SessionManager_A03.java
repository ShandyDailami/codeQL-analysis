import java.util.HashMap;
import java.util.Map;

public class java_10702_SessionManager_A03 {
    // This is a simplified HashMap, which is not secure for storing session data.
    // In a real application, we would use a more secure data structure like a database.
    private Map<String, String> sessionData = new HashMap<>();

    public void createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}
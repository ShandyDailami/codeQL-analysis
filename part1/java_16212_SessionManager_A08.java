import java.util.HashMap;
import java.util.Map;

public class java_16212_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_16212_SessionManager_A08() {
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

    // add more methods as needed for your specific use case
}
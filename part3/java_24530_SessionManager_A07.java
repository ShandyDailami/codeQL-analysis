import java.util.HashMap;
import java.util.Map;

public class java_24530_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_24530_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add other methods as necessary for your use case

    // Remainder of code is not provided, as this is not a typical Java application.
}
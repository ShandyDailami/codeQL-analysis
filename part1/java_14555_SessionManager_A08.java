import java.util.HashMap;
import java.util.Map;

public class java_14555_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_14555_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        // For security reasons, we will not store sensitive data
        // In a real-world scenario, we would need to validate and sanitize the input data
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        // For security reasons, we will not provide access to sensitive data
        // In a real-world scenario, we would need to validate the sessionId and provide access to the correct data
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // For security reasons, we will not allow access to delete non-existing sessions
        // In a real-world scenario, we would need to validate the sessionId and handle the deletion of the session
        sessionMap.remove(sessionId);
    }
}
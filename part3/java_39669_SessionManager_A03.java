import java.util.HashMap;
import java.util.Map;

public class java_39669_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39669_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // This is a security-sensitive operation, it's not recommended to use
        // the username directly in the sessionId. Instead, a hash function should be used.
        // For simplicity, we're skipping this operation here.
        sessionMap.put(username, "sessionId");
        return "sessionId";
    }

    public String getSessionAttribute(String sessionId, String attributeName) {
        // Check if session exists
        if (sessionMap.containsKey(sessionId)) {
            // Security-sensitive operation, not recommended to expose sensitive data
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void setSessionAttribute(String sessionId, String attributeName, String attributeValue) {
        // Security-sensitive operation, not recommended to expose sensitive data
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(attributeName, attributeValue);
        }
    }
}
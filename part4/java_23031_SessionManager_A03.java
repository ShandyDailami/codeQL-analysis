import java.util.HashMap;
import java.util.Map;

public class java_23031_SessionManager_A03 {
    private Map<String, Object> storage;

    public java_23031_SessionManager_A03() {
        storage = new HashMap<>();
    }

    public void createSession(String sessionId) {
        storage.put(sessionId, new Object());
    }

    public void setSessionAttribute(String sessionId, String attributeName, Object attributeValue) {
        if (storage.containsKey(sessionId)) {
            Map<String, Object> sessionData = (Map<String, Object>) storage.get(sessionId);
            sessionData.put(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(String sessionId, String attributeName) {
        if (storage.containsKey(sessionId)) {
            Map<String, Object> sessionData = (Map<String, Object>) storage.get(sessionId);
            return sessionData.get(attributeName);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        storage.remove(sessionId);
    }
}
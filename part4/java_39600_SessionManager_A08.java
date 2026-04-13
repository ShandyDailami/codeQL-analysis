import java.util.HashMap;
import java.util.Map;

public class java_39600_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_39600_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
   
    }

    public void setSessionAttribute(String sessionId, String attributeName, Object attributeValue) {
        Object sessionObject = getSession(sessionId);
        if (sessionObject != null) {
            Map<String, Object> sessionAttributes = (Map<String, Object>) sessionObject;
            sessionAttributes.put(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(String sessionId, String attributeName) {
        Object sessionObject = getSession(sessionId);
        if (sessionObject != null) {
            Map<String, Object> sessionAttributes = (Map<String, Object>) sessionObject;
            return sessionAttributes.get(attributeName);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
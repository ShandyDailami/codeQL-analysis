import java.util.HashMap;
import java.util.Map;

public class java_18803_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_18803_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void setSessionAttribute(String sessionId, String attributeName, String attributeValue) {
        sessionMap.put(sessionId, attributeName + "=" + attributeValue);
    }

    public String getSessionAttribute(String sessionId, String attributeName) {
        String attributeValue = sessionMap.get(sessionId);

        if (attributeValue != null) {
            int equalsIndex = attributeValue.indexOf('=');

            if (equalsIndex != -1 && attributeValue.substring(0, equalsIndex).equals(attributeName)) {
                return attributeValue.substring(equalsIndex + 1);
            }
        }

        return null;
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
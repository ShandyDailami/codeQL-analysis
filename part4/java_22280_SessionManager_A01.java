import java.util.HashMap;
import java.util.Map;

public class java_22280_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22280_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Start a session with the userId
        sessionMap.put(userId, "Started");
    }

    public void endSession(String userId) {
        // End a session with the userId
        sessionMap.remove(userId);
    }

    public String getSessionStatus(String userId) {
        // Get the status of the session with the userId
        return sessionMap.getOrDefault(userId, "Ended");
    }

    public void setSessionAttribute(String userId, String attributeName, String attributeValue) {
        // Set an attribute in the session with the userId
        sessionMap.put(userId + attributeName, attributeValue);
    }

    public String getSessionAttribute(String userId, String attributeName) {
        // Get the attribute in the session with the userId
        return sessionMap.getOrDefault(userId + attributeName, null).toString();
    }
}
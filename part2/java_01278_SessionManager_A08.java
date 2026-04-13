import java.util.HashMap;
import java.util.Map;

public class java_01278_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01278_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // In a real application, the userId would be hashed to prevent replay attacks
        // The sessionId would also be generated using a random key
        // For this example, we're only checking if the userId already exists in the sessionMap
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return null;
        }
    }

    public void setSessionId(String sessionId, String userId) {
        // In a real application, the sessionId would be validated before assigning it to a user
        // The userId would be hashed to prevent replay attacks
        // This method would also be used to assign a new sessionId to a user
        sessionMap.put(userId, sessionId);
    }

    public void removeSessionId(String userId) {
        // In a real application, this method would be used to remove a user's session
        // This would also clear the userId from the sessionMap
        sessionMap.remove(userId);
    }
}
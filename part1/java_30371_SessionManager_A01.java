import java.util.HashMap;
import java.util.Map;

public class java_30371_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30371_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        // This is a simple check for security sensitive operations.
        // In a real application, you would likely use a more secure method to get the user name.
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session is not valid, return null.
            return null;
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
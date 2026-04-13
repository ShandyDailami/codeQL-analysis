import java.util.HashMap;
import java.util.Map;

public class java_30563_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30563_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // This method is the one accessing the session data.
    public String getSessionData(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session not found: " + sessionId);
            return null;
        }

        // This is a simple security-sensitive operation.
        // The data is not being accessed without authentication.
        return sessionMap.get(sessionId);
    }

    // This method is the one modifying the session data.
    public void setSessionData(String sessionId, String data) {
        sessionMap.put(sessionId, data);
    }
}
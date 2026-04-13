import java.util.HashMap;
import java.util.Map;

public class java_11520_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_11520_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        sessionManager.createSession("session1", "value1");

        // Get session value
        String sessionValue = sessionManager.getSessionValue("session1");
        System.out.println("Session Value: " + sessionValue);

        // Delete session
        sessionManager.deleteSession("session1");
    }
}
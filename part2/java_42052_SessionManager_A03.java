import java.util.HashMap;
import java.util.Map;

public class java_42052_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_42052_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "data1");

        // Get session data
        String sessionData = sessionManager.getSessionData("session1");
        System.out.println("Session data: " + sessionData);

        // Delete a session
        sessionManager.deleteSession("session1");

        // Try to get deleted session data
        sessionData = sessionManager.getSessionData("session1");
        System.out.println("Trying to get deleted session data: " + sessionData);
    }
}
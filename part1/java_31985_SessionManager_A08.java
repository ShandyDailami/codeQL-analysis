import java.util.HashMap;
import java.util.Map;

public class java_31985_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_31985_SessionManager_A08() {
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

    // Adding a method for integrity check
    public boolean integrityCheck(String sessionId, String expectedData) {
        String data = sessionMap.get(sessionId);
        return data != null && data.equals(expectedData);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "data1");

        // Check integrity
        if (sessionManager.integrityCheck("session1", "data1")) {
            System.out.println("Integrity check passed");
        } else {
            System.out.println("Integrity check failed");
        }

        // Get session data
        String sessionData = sessionManager.getSessionData("session1");
        System.out.println("Session data: " + sessionData);

        // Delete session
        sessionManager.deleteSession("session1");
    }
}
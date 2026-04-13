import java.util.HashMap;
import java.util.Map;

public class java_14752_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14752_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
        return "Session created with ID: " + sessionId;
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session with ID: " + sessionId + " destroyed";
        } else {
            return "Session with ID: " + sessionId + " not found";
        }
    }

    public String checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session with ID: " + sessionId + " is Active";
        } else {
            return "Session with ID: " + sessionId + " not found";
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        String sessionId = "session1";
        System.out.println(sessionManager.createSession(sessionId));

        // Check if the session is active
        System.out.println(sessionManager.checkSession(sessionId));

        // Destroy the session
        System.out.println(sessionManager.destroySession(sessionId));
    }
}
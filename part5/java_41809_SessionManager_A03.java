import java.util.HashMap;
import java.util.Map;

public class java_41809_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_41809_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("session1", "sessionValue1");

        // Retrieve the session
        String sessionValue = sessionManager.getSession("session1");
        System.out.println("Retrieved session value: " + sessionValue);

        // Remove the session
        sessionManager.removeSession("session1");
    }
}
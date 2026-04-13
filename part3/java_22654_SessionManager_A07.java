import java.util.HashMap;
import java.util.Map;

public class java_22654_SessionManager_A07 {
    private Map<String, Object> sessionMap;

    public java_22654_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", new Object());

        // Get the session
        Object sessionObject = sessionManager.getSession("session1");
        System.out.println("Session object: " + sessionObject);

        // Delete the session
        sessionManager.deleteSession("session1");
    }
}
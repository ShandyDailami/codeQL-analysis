import java.util.HashMap;
import java.util.Map;

public class java_14895_SessionManager_A01 {
    private Map<String, Object> sessionMap;

    public java_14895_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
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

        // Get a session
        Object sessionObject = sessionManager.getSession("session1");
        System.out.println("Session object: " + sessionObject);

        // Delete a session
        sessionManager.deleteSession("session1");
    }
}
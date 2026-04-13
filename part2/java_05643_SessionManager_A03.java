import java.util.HashMap;
import java.util.Map;

public class java_05643_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05643_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "value1");

        // Get a session
        String value = sessionManager.getSession("session1");
        System.out.println("Session value: " + value);

        // Delete a session
        sessionManager.deleteSession("session1");
    }
}
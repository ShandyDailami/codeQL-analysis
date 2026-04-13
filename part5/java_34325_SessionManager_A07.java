import java.util.HashMap;
import java.util.Map;

public class java_34325_SessionManager_A07 {
    private Map<String, Object> sessionMap;

    public java_34325_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        sessionManager.createSession("session1", new Object());

        // Store value in session
        sessionManager.createSession("session1", "Hello, World!");

        // Retrieve value from session
        String value = (String) sessionManager.getSession("session1");
        System.out.println(value);  // Outputs: Hello, World!
    }
}
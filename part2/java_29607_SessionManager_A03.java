import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_29607_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_29607_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Create a session
        sessionManager.createSession("session1", "sessionValue1");

        // Retrieve the session
        String sessionValue = sessionManager.getSession("session1");
        System.out.println("Retrieved session value: " + sessionValue);

        // Delete the session
        sessionManager.deleteSession("session1");
    }
}
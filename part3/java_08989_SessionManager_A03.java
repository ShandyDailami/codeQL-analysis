import java.util.HashMap;
import java.util.Map;

public class java_08989_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_08989_SessionManager_A03() {
        sessionMap = new HashMap<>();
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
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "session1";
        String sessionValue = "session1 value";
        sessionManager.createSession(sessionId, sessionValue);

        // Get the session
        String getSessionValue = sessionManager.getSession(sessionId);
        System.out.println("Get session value: " + getSessionValue);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}
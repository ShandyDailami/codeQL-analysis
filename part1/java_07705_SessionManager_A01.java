import java.util.HashMap;

public class java_07705_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_07705_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
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
        sessionManager.createSession("session1");

        // Get the session
        System.out.println(sessionManager.getSession("session1")); // Should print sessionId

        // Delete the session
        sessionManager.deleteSession("session1");

        // Get the session again
        System.out.println(sessionManager.getSession("session1")); // Should print null
    }
}
import java.util.HashMap;

public class java_00751_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_00751_SessionManager_A03() {
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
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        manager.createSession("session1", "Session data 1");

        // Get session data
        System.out.println(manager.getSessionData("session1"));

        // Delete session
        manager.deleteSession("session1");
    }
}
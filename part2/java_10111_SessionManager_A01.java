import java.util.HashMap;

public class java_10111_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_10111_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Start a session
        manager.startSession("user1", "session1");

        // Get the session
        String session = manager.getSession("user1");
        System.out.println("Session: " + session);

        // End the session
        manager.endSession("user1");
    }
}
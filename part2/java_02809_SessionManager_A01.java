import java.util.HashMap;
import java.util.Map;

public class java_02809_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02809_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Example of how you might use this session manager
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Creating a session
        manager.createSession("session1", "user1");

        // Getting a user name from a session
        String userName = manager.getUserName("session1");
        System.out.println("User name: " + userName);

        // Deleting a session
        manager.deleteSession("session1");
    }
}
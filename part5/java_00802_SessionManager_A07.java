import java.util.HashMap;
import java.util.Map;

public class java_00802_SessionManager_A07 {

    // HashMap to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_00802_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String userId = "user1";
        String sessionId = manager.createSession(userId);

        // User logs in, sessionId is valid
        if (manager.isValidSession(sessionId)) {
            String user = manager.getUserId(sessionId);
            System.out.println("User " + user + " is logged in.");
        }

        // User logs out, session is no longer valid
        manager.removeSession(sessionId);
        if (!manager.isValidSession(sessionId)) {
            System.out.println("User is logged out.");
        }
    }
}
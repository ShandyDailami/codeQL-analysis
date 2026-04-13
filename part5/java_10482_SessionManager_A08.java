import java.util.HashMap;
import java.util.Map;

public class java_10482_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_10482_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session
        sessionManager.addSession("session1", "user1");

        // Get the user for a session
        String user = sessionManager.getUser("session1");
        System.out.println("User: " + user); // Should print "User: user1"

        // Delete a session
        sessionManager.deleteSession("session1");

        // Check if a session is valid
        boolean isValid = sessionManager.isValidSession("session1");
        System.out.println("Is Valid: " + isValid); // Should print "Is Valid: false"
    }
}
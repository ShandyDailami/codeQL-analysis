import java.util.HashMap;
import java.util.Map;

public class java_02713_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_02713_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Generate a unique session ID for the given username
        String sessionId = generateSessionId(username);
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + username);
    }

    private String generateSessionId(String username) {
        // This is a placeholder for the real implementation which generates a unique session ID
        // It could use a secure hash function or other suitable mechanism
        return username;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("alice");
        manager.startSession("bob");

        // Alice logs in, Bob logs out
        manager.endSession("alice");
        manager.startSession("bob");

        // Bob tries to access Alice's data, which should fail because Bob's session has expired
        System.out.println("Bob's username: " + manager.getUsername("bob"));
    }
}
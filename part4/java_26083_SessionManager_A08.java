import java.util.HashMap;

public class java_26083_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_26083_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId(username);
        sessionMap.put(sessionId, username);
        System.out.println("Session started for user: " + username + " with session id: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + username + " with session id: " + sessionId);
    }

    private String generateSessionId(String username) {
        // Here we would generate a secure session id based on the username
        // This is a simple example, and in a real application, you would need to use a more secure method
        return username;
    }
}
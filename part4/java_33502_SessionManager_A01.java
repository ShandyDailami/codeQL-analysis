import java.util.HashMap;

public class java_33502_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_33502_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to start a session
    public String startSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }

        // Simulate a long operation here
        // For example, we simulate a login session
        System.out.println("Starting session: " + sessionId);
        return sessionId;
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found with ID: " + sessionId);
            return;
        }

        System.out.println("Closing session: " + sessionId);
        sessionMap.remove(sessionId);
    }
}
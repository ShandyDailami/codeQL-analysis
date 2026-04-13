import java.util.HashMap;

public class java_21176_SessionManager_A03 {
    // Using HashMap as a simple storage for sessions
    private HashMap<String, String> sessionStorage;

    // Constructor
    public java_21176_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            // If sessionId is null or empty, generate a random ID
            sessionId = generateRandomSessionId();
        }

        // If sessionId already exists in the HashMap, return an error message
        if (sessionStorage.containsKey(sessionId)) {
            return "Error: Session ID already exists.";
        }

        // Otherwise, store the sessionId in the HashMap and return the sessionId
        sessionStorage.put(sessionId, "Active");
        return sessionId;
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            return "Error: Session ID is null or empty.";
        }

        // If sessionId does not exist in the HashMap, return an error message
        if (!sessionStorage.containsKey(sessionId)) {
            return "Error: No session found with the given ID.";
        }

        // Otherwise, remove the sessionId from the HashMap and return the sessionId
        sessionStorage.remove(sessionId);
        return sessionId;
    }

    // Method to generate a random session ID
    private String generateRandomSessionId() {
        // Implementation details depend on the specific needs of your project
        // Here, we're using a simple approach to generate a random ID
        return String.valueOf(System.currentTimeMillis() * (int) (Math.random() * 10000));
    }
}
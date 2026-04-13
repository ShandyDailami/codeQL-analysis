import java.util.HashMap;

public class java_02078_SessionManager_A07 {
    // Create a HashMap to store session data.
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to start a session.
    public String startSession(String userId) {
        // Generate a session id and store it in the session map.
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);

        // Return the session id.
        return sessionId;
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        // Remove the session id from the session map.
        sessionMap.remove(sessionId);
    }

    // Method to get the user id for a session id.
    public String getUserId(String sessionId) {
        // Retrieve the user id from the session map.
        return sessionMap.get(sessionId);
    }

    // Method to check if a session id is valid.
    public boolean isValidSession(String sessionId) {
        // Check if the session id is in the session map.
        return sessionMap.containsKey(sessionId);
    }

    // Method to generate a session id.
    private String generateSessionId() {
        // Here, we're using a simple method to generate a session id.
        // In a real-world application, you'd want to use a more complex method,
        // possibly including a UUID, time, and other information.
        return String.valueOf(System.currentTimeMillis());
    }
}
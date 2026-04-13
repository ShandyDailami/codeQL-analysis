import java.util.HashMap;

public class java_23155_SessionManager_A08 {
    // Using HashMap as storage to avoid explicit database interaction.
    private HashMap<String, String> storage;

    public java_23155_SessionManager_A08() {
        storage = new HashMap<>();
    }

    // Method to add a session.
    public void addSession(String sessionId, String userId) {
        storage.put(sessionId, userId);
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Simplistic check, in a real application we would want to check against a more secure token.
        if (storage.containsKey(sessionId)) {
            return storage.get(sessionId);
        } else {
            System.out.println("Invalid Session ID!");
            return null;
        }
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        storage.remove(sessionId);
    }
}
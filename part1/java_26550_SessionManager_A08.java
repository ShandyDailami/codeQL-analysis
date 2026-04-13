import java.util.HashMap;
import java.util.Map;

public class java_26550_SessionManager_A08 {
    // HashMap to store the session data
    private Map<String, String> sessionData;

    public java_26550_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to add data to the session
    public void addData(String key, String value) {
        sessionData.put(key, value);
    }

    // Method to retrieve data from the session
    public String getData(String key) {
        return sessionData.get(key);
    }

    // Method to remove the session
    public void removeSession() {
        sessionData.clear();
    }

    public static void main(String[] args) {
        // Create a new session manager
        LegacySessionManager sessionManager = new LegacySessionManager();

        // Add some data to the session
        sessionManager.addData("sessionId", "12345");
        sessionManager.addData("userId", "67890");

        // Retrieve the data from the session
        String sessionId = sessionManager.getData("sessionId");
        String userId = sessionManager.getData("userId");

        System.out.println("Session ID: " + sessionId);
        System.out.println("User ID: " + userId);

        // Remove the session
        sessionManager.removeSession();
    }
}
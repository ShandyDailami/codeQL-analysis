import java.util.HashMap;
import java.util.Map;

public class java_27370_SessionManager_A07 {
    // Session data is stored in a HashMap.
    private Map<String, String> sessionData;

    public java_27370_SessionManager_A07() {
        sessionData = new HashMap<String, String>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        // Create a session and store userId as the value.
        sessionData.put(userId, userId);
        return userId;
    }

    // Method to get the session data.
    public String getSessionData(String userId) {
        // Return the session data if it exists, otherwise return null.
        return sessionData.getOrDefault(userId, null);
    }

    // Method to remove the session.
    public void removeSession(String userId) {
        // Remove the session.
        sessionData.remove(userId);
    }
}
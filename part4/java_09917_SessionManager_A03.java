import java.util.HashMap;

public class java_09917_SessionManager_A03 {
    // HashMap to store session data
    private HashMap<String, String> sessionData = new HashMap<>();

    // Authenticate user
    public boolean authenticate(String username, String password) {
        // Simulated authentication
        return username != null && password != null;
    }

    // Store session data
    public void storeSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    // Retrieve session data
    public String retrieveSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Remove session data
    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}
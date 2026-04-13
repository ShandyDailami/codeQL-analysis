import java.util.HashMap;

public class java_05045_SessionManager_A03 {

    // Define a private HashMap to store session data
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_05045_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session key using userId
        String sessionKey = userId + System.currentTimeMillis();
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to get the userId of a session
    public String getUserId(String sessionKey) {
        return sessionMap.get(sessionKey);
    }

    // Method to delete a session
    public void deleteSession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }
}
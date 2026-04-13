import java.util.HashMap;
import java.util.Map;

public class java_07755_SessionManager_A08 {
    // Store sessions in a HashMap
    private Map<String, String> sessionMap;

    public java_07755_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create session
    public String createSession(String userId) {
        // Generate a random session key
        String sessionKey = generateSessionKey(userId);
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Validate session
    public boolean validateSession(String sessionKey, String expectedUserId) {
        // Check if the session exists and the user ID matches
        return sessionMap.containsKey(sessionKey) && sessionMap.get(sessionKey).equals(expectedUserId);
    }

    // Destroy session
    public void destroySession(String sessionKey) {
        // Remove the session from the map
        sessionMap.remove(sessionKey);
    }

    // Util function to generate a session key
    private String generateSessionKey(String userId) {
        // Implementing a simple hashing function for demonstration purposes
        // In a real-world scenario, use a more secure method for generating session keys
        int hash = 0;
        char[] charArray = userId.toCharArray();
        for (char c : charArray) {
            hash += c;
        }
        return String.valueOf(hash);
    }
}
import java.util.HashMap;
import java.util.Map;

public class java_20523_SessionManager_A07 {
    private Map<String, String> userMap; // Simple in-memory user map

    public java_20523_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1"); // Add more users as needed
    }

    public String createSession(String username, String password) {
        if (isValidUser(username, password)) {
            String sessionId = generateSessionId();
            userMap.put(username, sessionId);
            return sessionId;
        } else {
            return null; // Return null or throw exception for authentication failure
        }
    }

    public String getSession(String sessionId) {
        return userMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        String username = userMap.get(sessionId);
        if (username != null) {
            userMap.remove(username);
        }
    }

    private boolean isValidUser(String username, String password) {
        return username != null && password != null && username.equals("user1") && password.equals("password1");
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString(); // Replace with a more secure UUID generation mechanism
    }
}
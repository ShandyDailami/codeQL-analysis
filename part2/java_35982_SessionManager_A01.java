import java.util.HashMap;
import java.util.Map;

public class java_35982_SessionManager_A01 {
    // A map to simulate a database with session IDs and users
    private Map<String, String> sessionUsersMap;

    public java_35982_SessionManager_A01() {
        sessionUsersMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionUsersMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        return sessionUsersMap.get(sessionId);
    }

    // Method to check if a user has a session
    public boolean hasSession(String user) {
        return sessionUsersMap.containsValue(user);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionUsersMap.containsKey(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        if (isValidSession(sessionId)) {
            String user = sessionUsersMap.get(sessionId);
            sessionUsersMap.remove(sessionId);
            System.out.println("User " + user + " has been logged out.");
        } else {
            System.out.println("Invalid session.");
        }
    }
}
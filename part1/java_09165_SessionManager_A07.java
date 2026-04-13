import java.util.HashMap;
import java.util.Map;

public class java_09165_SessionManager_A07 {

    // A map to store the sessions.
    private Map<String, String> sessionMap;

    // The username and password for the sessions.
    private String validUsername;
    private String validPassword;

    // Constructor to initialize the session map.
    public java_09165_SessionManager_A07() {
        sessionMap = new HashMap<>();
        validUsername = "user";
        validPassword = "password";
    }

    // Method to validate a username and password.
    public boolean validateUser(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    // Method to create a session for a user.
    public String createSession(String username, String password) {
        if (validateUser(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the username from a session.
    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to generate a session id.
    private String generateSessionId() {
        return Integer.toString(sessionMap.size() + 1);
    }
}
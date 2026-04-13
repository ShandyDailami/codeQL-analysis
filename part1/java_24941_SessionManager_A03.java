import java.util.HashMap;
import java.util.Map;

public class java_24941_SessionManager_A03 {

    // Create a HashMap to store user sessions
    private Map<String, String> sessionMap;

    public java_24941_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // In a real-world application, you would have to add logic to generate a unique session ID and
        // validate that the username is not already in the session map to prevent injection attacks.
        String sessionId = "session_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username associated with a session
    public String getUsername(String sessionId) {
        // Again, in a real-world application, you would have to validate that the sessionId is valid and
        // not expired to prevent XSS attacks.
        return sessionMap.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}
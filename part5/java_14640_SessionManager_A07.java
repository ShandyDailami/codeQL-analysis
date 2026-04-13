import java.util.HashMap;
import java.util.Map;

public class java_14640_SessionManager_A07 {

    // This is a very simple and basic session management system.
    // In a real-world application, session management would be much more complex.

    private Map<String, String> sessionMap;

    public java_14640_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        // Generate a session ID and store it in the map.
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Started session for user: " + userName + " with ID: " + sessionId);
    }

    public String getUserName(String sessionId) {
        // Retrieve the user name from the map based on the session ID.
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Remove the session from the map.
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + getUserName(sessionId) + " with ID: " + sessionId);
    }

    // This is a very simple way to generate a session ID. In a real-world application,
    // you would likely use a UUID or some other unique identifier.
    private String generateSessionId() {
        // Generate a random session ID.
        // This is not secure, but it's a start.
        return String.valueOf(System.currentTimeMillis());
    }
}
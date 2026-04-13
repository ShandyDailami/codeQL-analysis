import java.util.HashMap;
import java.util.Map;

public class java_17072_SessionManager_A03 {

    // We use a map to simulate a database
    private Map<String, String> sessionMap;

    // We create a constructor
    public java_17072_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // We create a method to start a session
    public String startSession(String userName) {
        // Create a session ID and store it in the map
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);

        return sessionId;
    }

    // We create a method to get a user name based on a session ID
    public String getUserName(String sessionId) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // We create a method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }
}
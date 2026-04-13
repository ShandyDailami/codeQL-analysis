import java.util.HashMap;
import java.util.Map;

public class java_18777_SessionManager_A08 {

    // Private Map for storing sessions
    private Map<Integer, String> sessionMap;

    // Initialization of the session map
    public java_18777_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionData) {
        // Create a hash code from the session data
        int hashCode = sessionData.hashCode();

        // Store the session data in the session map using the hash code as the key
        sessionMap.put(hashCode, sessionData);

        // Return the hash code
        return Integer.toString(hashCode);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        // Convert the session id string to an integer
        int hashCode = Integer.parseInt(sessionId);

        // Check if the session map contains a session with the given hash code
        if (sessionMap.containsKey(hashCode)) {
            // Return the session data from the session map
            return sessionMap.get(hashCode);
        } else {
            // Return null if the session does not exist
            return null;
        }
    }
}
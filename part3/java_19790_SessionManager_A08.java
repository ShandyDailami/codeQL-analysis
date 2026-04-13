import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class java_19790_SessionManager_A08 {

    // Map to store session IDs and their corresponding users
    private Map<String, String> sessionIDToUserMap;

    // Set to store active sessions
    private Set<String> activeSessions;

    public java_19790_SessionManager_A08() {
        sessionIDToUserMap = new HashMap<>();
        activeSessions = new HashSet<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        // Generate a session ID
        String sessionID = "A08_SessionID" + System.currentTimeMillis();

        // Add the session ID and user to the maps
        sessionIDToUserMap.put(sessionID, user);
        activeSessions.add(sessionID);

        return sessionID;
    }

    // Method to validate a session ID
    public String validateSessionID(String sessionID) {
        if (sessionIDToUserMap.containsKey(sessionID) && activeSessions.contains(sessionID)) {
            return sessionIDToUserMap.get(sessionID);
        } else {
            throw new SecurityException("Invalid session ID");
        }
    }
}
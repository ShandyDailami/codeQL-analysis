import java.util.HashMap;
import java.util.UUID;

public class java_24389_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_24389_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionData) {
        // Create a unique session ID
        String sessionID = UUID.randomUUID().toString();

        // Store the session data in the session map
        sessionMap.put(sessionID, sessionData);

        return sessionID;
    }

    public String getSessionData(String sessionID) {
        // Return the session data if it exists, otherwise return null
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        // Remove the session from the session map
        sessionMap.remove(sessionID);
    }
}
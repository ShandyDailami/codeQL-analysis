import java.util.HashMap;
import java.util.Map;

public class java_29242_SessionManager_A03 {
    // A map to store user sessions.
    private Map<String, String> sessionMap;

    public java_29242_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to get the userID associated with a session.
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to remove a session.
    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}
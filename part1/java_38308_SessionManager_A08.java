import java.util.HashMap;
import java.util.Map;

public class java_38308_SessionManager_A08 {
    // A HashMap to store session data
    private Map<String, Object> sessionData;

    // Constructor
    public java_38308_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object sessionData) {
        String sessionID = UUID.randomUUID().toString();
        this.sessionData.put(sessionID, sessionData);
        return sessionID;
    }

    // Method to get session data
    public Object getSessionData(String sessionID) {
        return sessionData.get(sessionID);
    }

    // Method to remove session
    public void removeSession(String sessionID) {
        sessionData.remove(sessionID);
    }
}
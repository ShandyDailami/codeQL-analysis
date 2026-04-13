import java.util.HashMap;
import java.util.Map;

public class java_08738_SessionManager_A07 {

    // Create a HashMap to store the sessions. Key is session ID.
    private Map<String, String> sessionMap;

    public java_08738_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session.
    public String startSession(String userID) {
        String sessionID = Integer.toString(userID.hashCode());
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session.
    public String validateSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            return null;
        }
    }

    // Method to end a session.
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}
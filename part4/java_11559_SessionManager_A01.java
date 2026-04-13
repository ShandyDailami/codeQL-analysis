import java.util.HashMap;
import java.util.Map;

public class java_11559_SessionManager_A01 {
    private Map<String, String> userDatabase;
    private Map<String, String> sessionDatabase;

    public java_11559_SessionManager_A01() {
        userDatabase = new HashMap<>();
        sessionDatabase = new HashMap<>();
    }

    public String createSession(String userID) {
        // Check if user exists
        if (userDatabase.containsKey(userID)) {
            // Create a session for the user
            String sessionID = userID + System.currentTimeMillis();
            sessionDatabase.put(sessionID, userID);
            return sessionID;
        } else {
            return "User not found";
        }
    }

    public String getUserID(String sessionID) {
        // Check if session exists and is valid
        if (sessionDatabase.containsKey(sessionID)) {
            return sessionDatabase.get(sessionID);
        } else {
            return "Invalid session";
        }
    }
}
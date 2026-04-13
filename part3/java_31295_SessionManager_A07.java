import java.util.HashMap;
import java.util.Map;

public class java_31295_SessionManager_A07 {
    private Map<String, String> sessionData;

    public java_31295_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionID, String userID) {
        sessionData.put(sessionID, userID);
    }

    public String getUserID(String sessionID) {
        return sessionData.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionData.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Start a new session and store user ID
        sm.startSession("session1", "user1");

        // Retrieve user ID from session
        String userID = sm.getUserID("session1");
        System.out.println("User ID: " + userID); // Output: User ID: user1

        // End the session
        sm.endSession("session1");
    }
}
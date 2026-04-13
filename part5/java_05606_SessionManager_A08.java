import java.util.HashMap;
import java.util.Map;

public class java_05606_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05606_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = "A08_IntegrityFailure"; // this is a placeholder. Generate it in real use case.
        sessionMap.put(userID, sessionID);
        return sessionID;
    }

    public String getSession(String userID) {
        return sessionMap.get(userID);
    }

    public void deleteSession(String userID) {
        sessionMap.remove(userID);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String userID = "user1";
        String sessionID = sessionManager.createSession(userID);
        System.out.println("Created session for user " + userID + ". SessionID: " + sessionID);

        // Get the session
        sessionID = sessionManager.getSession(userID);
        System.out.println("Retrieved session for user " + userID + ". SessionID: " + sessionID);

        // Delete the session
        sessionManager.deleteSession(userID);
        System.out.println("Deleted session for user " + userID);
    }
}
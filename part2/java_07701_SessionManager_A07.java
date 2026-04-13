import java.util.HashMap;

public class java_07701_SessionManager_A07 {

    // Create a HashMap to store session IDs and users
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String user) {
        // Generate a session ID and store it in the HashMap
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    // Method to get the user associated with a session
    public String getUser(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session from the HashMap
        sessionMap.remove(sessionID);
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionID = sm.createSession("User1");
        System.out.println("Session ID: " + sessionID);
        String user = sm.getUser(sessionID);
        System.out.println("User: " + user);
        sm.endSession(sessionID);
    }
}
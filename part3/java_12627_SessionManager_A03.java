import java.util.UUID;
import java.util.HashMap;

public class java_12627_SessionManager_A03 {
    // A HashMap to hold session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_12627_SessionManager_A03() {
        this.sessionData = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String username) {
        // Create a new UUID for the session ID
        String sessionID = UUID.randomUUID().toString();

        // Associate the username and session ID in the session data
        sessionData.put(sessionID, username);

        // Return the session ID
        return sessionID;
    }

    // Method to get the username from a session
    public String getUsername(String sessionID) {
        // Retrieve the username from the session data
        return sessionData.get(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session data from the session data
        sessionData.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Start a new session
        String sessionID = manager.startSession("Alice");
        System.out.println("Started session with ID: " + sessionID);

        // Get the username from the session
        String username = manager.getUsername(sessionID);
        System.out.println("Username: " + username);

        // End the session
        manager.endSession(sessionID);
        System.out.println("Ended session with ID: " + sessionID);
    }
}